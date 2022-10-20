package com.example.customer_management.repository;

import com.example.customer_management.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IProductRepository extends JpaRepository<Product,Integer > {
    List<Product> findAllByNameContaining(String name);
}
