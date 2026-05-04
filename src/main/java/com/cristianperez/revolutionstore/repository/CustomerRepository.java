package com.cristianperez.revolutionstore.repository;

import com.cristianperez.revolutionstore.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
