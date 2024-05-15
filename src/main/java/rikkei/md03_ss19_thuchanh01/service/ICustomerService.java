package rikkei.md03_ss19_thuchanh01.service;

import rikkei.md03_ss19_thuchanh01.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    Customer findById(int id);
    void save(Customer customer);
    void update(int id, Customer customer);
    void delete(int id);
}
