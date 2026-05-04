package com.cristianperez.revolutionstore.service;

import com.cristianperez.revolutionstore.entity.Product;
import com.cristianperez.revolutionstore.exception.ResourceNotFoundException;
import com.cristianperez.revolutionstore.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public List<Product> list() {
        return productRepository.findAll();
    }

    @Override
    public Product getByCode(Integer id) {
        return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product with ID not found: " + id ));
    }

    @Override
    public Product create(Product product) {
        product.setCodeProduct(null);
        return null;
    }

    @Override
    public Product update(Integer id, Product product) {
        Product existing = getByCode(id);
        existing.setProductName(product.getProductName());
        existing.setPriceProduct(product.getPriceProduct());
        existing.setStockProduct(product.getStockProduct());
        existing.setStatusProduct(product.isStatusProduct());;
        return productRepository.save(existing);
    }

    @Override
    public void eliminate(Integer id) {
        if (!productRepository.existsById(id)){
            throw new ResourceNotFoundException("Product with ID not found: " + id);
        }
        productRepository.deleteById(id);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }
}
