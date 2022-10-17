package formDataBinding.service;

import formDataBinding.model.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();
    void save (Employee employee);
}
