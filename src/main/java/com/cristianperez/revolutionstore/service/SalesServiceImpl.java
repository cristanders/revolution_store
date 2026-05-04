package com.cristianperez.revolutionstore.service;

import com.cristianperez.revolutionstore.entity.Sales;
import com.cristianperez.revolutionstore.exception.ResourceNotFoundException;
import com.cristianperez.revolutionstore.repository.SalesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesServiceImpl implements SalesService{
    private final SalesRepository salesRepository;

    public SalesServiceImpl(SalesRepository salesRepository) {
        this.salesRepository = salesRepository;
    }

    @Override
    public List<Sales> list() {
        return salesRepository.findAll();
    }

    @Override
    public Sales getByCode(Integer id) {
        return salesRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Sales with ID not found: " + id ));
    }

    @Override
    public Sales create(Sales sales) {
        sales.setCodeSales(null);
        return null;
    }

    @Override
    public Sales update(Integer id, Sales sales) {
        Sales existing = getByCode(id);
        existing.setSaleDate(sales.getSaleDate());
        existing.setTotalSales(sales.getTotalSales());
        existing.setStatusSales(sales.getStatusSales());
        existing.setCustomer(sales.getCustomer());
        existing.setUser(sales.getUser());
        return salesRepository.save(existing);
    }

    @Override
    public void eliminate(Integer id) {

        if (!salesRepository.existsById(id)){
            throw new ResourceNotFoundException("sales with ID not found: " + id);
        }
        salesRepository.deleteById(id);
    }

    @Override
    public void save(Sales sales) {

        salesRepository.save(sales);
    }
}
