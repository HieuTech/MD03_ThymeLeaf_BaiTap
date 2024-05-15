package rikkei.md03_ss19_thuchanh01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import rikkei.md03_ss19_thuchanh01.model.Customer;
import rikkei.md03_ss19_thuchanh01.service.CustomerServiceIMPL;

import java.util.List;

@Controller
@RequestMapping(value={"/","/customer"})
public class CustomerController {
    @Autowired
    CustomerServiceIMPL customerServiceIMPL;

    @GetMapping()
    public String index(ModelMap modelMap){
        List<Customer> customers = this.customerServiceIMPL.findAll();
        modelMap.addAttribute("customers",customers);
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("customer", new Customer());
        return "/create";
    }
    @PostMapping("/save")
    public String save(Customer customer){
        this.customerServiceIMPL.save(customer);
        return "redirect:/";
    }
    @GetMapping("/{id}/edit")
    public String showUpdate(@PathVariable int id, Model model){
        model.addAttribute("customer", this.customerServiceIMPL.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String updateCustomer(Customer customer){
        this.customerServiceIMPL.update(customer.getId(), customer);
        return "redirect:/customer";
    }

    @GetMapping("/{id}/delete")
    public String showDelete(@PathVariable int id, Model model){
        model.addAttribute("customer", this.customerServiceIMPL.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String deleteCustomer(Customer customer){
        this.customerServiceIMPL.delete(customer.getId());
        return "redirect:/customer";
    }

    @GetMapping("/{id}/view")
    public String showView(@PathVariable int id, Model model){
        model.addAttribute("customer", this.customerServiceIMPL.findById(id));
        return "/view";
    }

}
