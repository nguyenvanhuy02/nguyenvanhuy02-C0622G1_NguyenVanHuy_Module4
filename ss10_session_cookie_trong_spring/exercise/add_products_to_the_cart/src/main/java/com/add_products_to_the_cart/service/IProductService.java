package com.add_products_to_the_cart.service;

import com.add_products_to_the_cart.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product> findAll();
    Optional<Product> findById(int id);
    void save(Product product);
}
