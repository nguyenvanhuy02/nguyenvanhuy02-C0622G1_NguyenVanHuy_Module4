package formDataBinding.service.impl;

import formDataBinding.model.Employee;
import formDataBinding.service.IEmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    private static List<Employee> employees = new ArrayList<>();
        static {
            employees.add( new Employee("1","Nguyễn Văn An", "03556981"));
            employees.add( new Employee("2","Đặng Văn Anh", "03556981"));
            employees.add( new Employee("3","Cao Văn Ân", "03556981"));
            employees.add( new Employee("4","Đâm Văn An", "03556981"));
        }
    @Override
    public List<Employee> findAll() {
        return employees;
    }

    @Override
    public void save(Employee employee) {
        employees.add(employee);
    }
}
