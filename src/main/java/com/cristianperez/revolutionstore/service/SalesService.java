package com.cristianperez.revolutionstore.service;


import com.cristianperez.revolutionstore.entity.Sales;

import java.util.List;

public interface SalesService {
    List<Sales> list();
    Sales getByCode(Integer id);
    Sales create(Sales sales);
    Sales update(Integer id, Sales sales);
    void eliminate(Integer id);
    void save(Sales sales);
}
