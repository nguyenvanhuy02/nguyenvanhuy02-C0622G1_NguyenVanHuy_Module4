package com.case_study.service;

import com.case_study.model.customer.CustomerType;

import java.util.List;

public interface ICustomerTypeService {

    List<CustomerType> findAll();
}
