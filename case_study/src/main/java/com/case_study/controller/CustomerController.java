package com.case_study.controller;

import com.case_study.model.customer.Customer;
import com.case_study.service.ICustomerService;
import com.case_study.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ICustomerTypeService customerTypeService;

    @GetMapping
    public String showList(@RequestParam (value = "page" , defaultValue = "0") Integer page,
                            @RequestParam (name = "name",defaultValue = "") String name,
                            @RequestParam (name = "email",defaultValue = "") String email,
                            @RequestParam (name = "customerTypeId",defaultValue = "") String customerTypeId,
                            @RequestParam (name = "status",defaultValue = "1") String status,
                            Model model  ){
        Sort sort = Sort.by("name").ascending();
        model.addAttribute("customerTypeList", customerTypeService.findAll());
        model.addAttribute("name", name);
        model.addAttribute("email", email);
        model.addAttribute("customerTypeId", customerTypeId);
        if (customerTypeId.equals("") && name.equals("") && email.equals("")) {
            model.addAttribute("customerPage", customerService.findByStatus(status, PageRequest.of(page, 5, sort)));
        } else if (customerTypeId.equals("")) {
            model.addAttribute("customerPage", customerService.findByNameAndEmail(name, email, status, PageRequest.of(page, 5, sort)));
        } else {
            model.addAttribute("customerPage", customerService.findByNameAndEmailAndCustomerType(name, email, status, customerTypeId, PageRequest.of(page, 5, sort)));
        }
        return "/customer/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("customerList",new Customer());
        return "customer/create";
    }
}
