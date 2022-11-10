package com.case_study.controller;

import com.case_study.dto.CustomerDto;
import com.case_study.model.customer.Customer;
import com.case_study.model.customer.CustomerType;
import com.case_study.repository.customer.IGenderRepository;
import com.case_study.service.customer.ICustomerService;
import com.case_study.service.customer.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ICustomerTypeService customerTypeService;

    @Autowired
    private IGenderRepository genderRepository;

    @ModelAttribute("customerTypeList")
    public List<CustomerType> customerTypes(){
        return customerTypeService.findAll();
    }

    @GetMapping
    public String showList(@RequestParam (value = "page" , defaultValue = "0") Integer page,
                            @RequestParam (name = "name",defaultValue = "") String name,
                            @RequestParam (name = "email",defaultValue = "") String email,
                            @RequestParam (name = "customerTypeId",defaultValue = "") String customerTypeId,
                            @RequestParam (name = "status",defaultValue = "1") String status,
                            Model model  ){
        Sort sort = Sort.by("name").ascending();
//        model.addAttribute("customerTypeList", customerTypeService.findAll());
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
//        model.addAttribute("customerTypeList",customerTypeService.findAll());
        model.addAttribute("genderList",genderRepository.findAll());
        model.addAttribute("customerDto",new CustomerDto());

        return "customer/create";
    }

    @PostMapping("/save")
    public String save(@Validated @ModelAttribute("") CustomerDto customerDto ,
                       BindingResult bindingResult, RedirectAttributes redirect,
                       Model model){
        model.addAttribute("genderList",genderRepository.findAll());
        new CustomerDto().validate(customerDto,bindingResult);
        if (bindingResult.hasFieldErrors()){
            return "/customer/create";
        }else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto,customer);
            customerService.save(customer);
            redirect.addFlashAttribute("mess","Thêm mới thành công !");
            return "redirect:/customer";
        }

    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id , Model model){
//        model.addAttribute("customerTypeList",customerTypeService.findAll());
        model.addAttribute("genderList",genderRepository.findAll());
        model.addAttribute("customerDto",customerService.findById(id));
        return "/customer/edit";
    }

    @PostMapping("/update")
    public String update(@Validated
                         @ModelAttribute(value = "customerDto")
                         CustomerDto customerDto ,
                         BindingResult bindingResult,RedirectAttributes redirect,
                         Model model){
        model.addAttribute("genderList",genderRepository.findAll());
        new CustomerDto().validate(customerDto,bindingResult);
        if (bindingResult.hasFieldErrors()){
            return "/customer/edit";
        }else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto,customer);
            customerService.save(customer);
            redirect.addFlashAttribute("mess","Chỉnh sửa thành công !");
            return "redirect:/customer";
        }
    }

    @GetMapping("/{id}/view")
    public String viewCustomer(@PathVariable int id , Model model){
        model.addAttribute("customer",customerService.findById(id));
        return "/customer/view";
    }

    @GetMapping("/{id}/delete")
    public String deleteCustomer(@PathVariable int id,
                                 RedirectAttributes redirect){
        Customer customer = customerService.findById(id);
        customer.setStatus(0);
        customerService.save(customer);
        redirect.addFlashAttribute("mess","Xoá thành công !" + customer.getName());
        return "redirect:/customer";
    }
}
