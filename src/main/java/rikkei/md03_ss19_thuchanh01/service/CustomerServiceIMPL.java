package rikkei.md03_ss19_thuchanh01.service;

import org.springframework.stereotype.Service;
import rikkei.md03_ss19_thuchanh01.model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustomerServiceIMPL implements ICustomerService{
    private static final Map<Integer,Customer> customers;

    static
    {
        customers = new HashMap<>();
        customers.put(1,new Customer(1,"Java", "name@gmail.com","address"));
        customers.put(2,new Customer(2,"Java3", "name@gmail.com","address"));
        customers.put(3,new Customer(3,"Java3", "name3@gmail.com","address3"));
        customers.put(4,new Customer(4,"Java3", "name3@gmail.com","address3"));
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public Customer findById(int id) {
        return customers.get(id);
    }

    @Override
    public void save(Customer customer) {
        customer.setId(getNewId());
        customers.put(getNewId(), customer);
    }

    @Override
    public void update(int id, Customer customer) {
        customers.put(id,customer);
    }

    @Override
    public void delete(int id) {
        customers.remove(id);
    }

    private int getNewId(){
        int idMax = 0;
        for (Map.Entry e : customers.entrySet()){
            int id = (int) e.getKey();
                if(id > idMax){
                    idMax = id;
                }
            }
        return idMax +1;
    }
}
