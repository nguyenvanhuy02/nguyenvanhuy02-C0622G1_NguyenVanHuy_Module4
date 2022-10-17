package formDataBinding.controller;


import formDataBinding.model.Employee;
import formDataBinding.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;

    @GetMapping("")
    public String showList(Model model){
        List<Employee> employeeList = employeeService.findAll();
        model.addAttribute("employeeList",employeeList);
        return "/listEmployee";
    }

    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("employee",new Employee());

        return "/addEmployee";
    }

    @PostMapping("/create")
    public String createEmployee(@ModelAttribute Employee employee){
        employeeService.save(employee);
        return "redirect:/employee";
    }
}
