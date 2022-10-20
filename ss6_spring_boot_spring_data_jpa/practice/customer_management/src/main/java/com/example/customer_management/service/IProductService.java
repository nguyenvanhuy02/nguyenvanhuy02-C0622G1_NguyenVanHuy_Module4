package com.example.customer_management.service;

import com.example.customer_management.model.Product;


import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void save(Product product);

    Product findById(Integer id);

    void update( Product product);

    void remove(int id);

    List<Product> findByName(String name);
}
