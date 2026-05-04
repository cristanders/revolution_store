package com.cristianperez.revolutionstore.repository;

import com.cristianperez.revolutionstore.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
