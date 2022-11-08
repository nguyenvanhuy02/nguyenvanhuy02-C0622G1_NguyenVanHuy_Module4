package com.case_study.service.impl.employee;

import com.case_study.model.employee.Employee;
import com.case_study.repository.employee.IEmployeeRepository;
import com.case_study.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }
}
