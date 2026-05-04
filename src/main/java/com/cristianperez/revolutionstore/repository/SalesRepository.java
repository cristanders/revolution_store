package com.cristianperez.revolutionstore.repository;


import com.cristianperez.revolutionstore.entity.Sales;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesRepository extends JpaRepository<Sales, Integer> {
}
