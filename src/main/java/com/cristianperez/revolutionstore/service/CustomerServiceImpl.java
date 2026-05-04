package com.cristianperez.revolutionstore.service;

import com.cristianperez.revolutionstore.entity.Customer;
import com.cristianperez.revolutionstore.exception.ResourceNotFoundException;
import com.cristianperez.revolutionstore.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    public List<Customer> list() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getByDpi(Integer id) {
        return customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer with ID not found" + id));
    }

    @Override
    public Customer create(Customer customer) {
        customer.setDpiCustomer(null);
        return null;
    }

    @Override
    public Customer update(Integer id, Customer customer) {
        Customer existing = getByDpi(id);
        existing.setFirstName(customer.getFirstName());
        existing.setLastName(customer.getLastName());
        existing.setAddress(customer.getAddress());
        existing.setStatusCustomer(customer.getStatusCustomer());
    return customerRepository.save(existing);
    }

    @Override
    public void eliminate(Integer id) {
        if (!customerRepository.existsById(id)){
            throw new ResourceNotFoundException("Customer with ID not found: " + id);
        }
        customerRepository.deleteById(id);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }
}
