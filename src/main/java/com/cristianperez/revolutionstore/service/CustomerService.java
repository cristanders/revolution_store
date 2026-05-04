package com.cristianperez.revolutionstore.service;

import com.cristianperez.revolutionstore.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> list();
    Customer getByDpi(Integer id);
    Customer create(Customer customer);
    Customer update(Integer id, Customer customer);
    void eliminate(Integer id);
    void save(Customer customer);
}

