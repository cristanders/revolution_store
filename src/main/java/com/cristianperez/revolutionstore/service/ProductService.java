package com.cristianperez.revolutionstore.service;

import com.cristianperez.revolutionstore.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> list();
    Product getByCode(Integer id);
    Product create(Product product);
    Product update(Integer id, Product product);
    void eliminate(Integer id);
    void save(Product product);
}
