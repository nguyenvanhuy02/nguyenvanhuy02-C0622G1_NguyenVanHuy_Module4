package com.case_study.service.customer;

import com.case_study.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {

    Page<Customer> findAll(Pageable pageable);

    Page<Customer> findByNameAndEmailAndCustomerType(String name, String email, String customerTypeId, String status, Pageable pageable);

    Page<Customer> findByNameAndEmail(String name, String email, String status, Pageable pageable);

    Page<Customer> findByStatus(String status, Pageable pageable);

    void save(Customer customer);

    Customer findById(Integer id);

    List<Customer> customerList();

}
