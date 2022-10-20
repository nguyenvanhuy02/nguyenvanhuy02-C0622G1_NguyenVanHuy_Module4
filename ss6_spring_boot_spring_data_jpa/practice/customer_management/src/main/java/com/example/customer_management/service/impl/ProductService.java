package com.example.customer_management.service.impl;

import com.example.customer_management.model.Product;
import com.example.customer_management.repository.IProductRepository;
import com.example.customer_management.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Product product) {
        productRepository.save(product);
    }

    @Override
    public void remove(int id) {
        productRepository.delete(findById(id));
    }

    @Override
    public List<Product> findByName(String name) {
        return productRepository.findAllByNameContaining(name);
    }
}
