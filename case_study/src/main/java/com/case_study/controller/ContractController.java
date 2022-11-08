package com.case_study.controller;

import com.case_study.dto.ContractDto;
import com.case_study.model.contract.Contract;
import com.case_study.service.contract.IContractService;
import com.case_study.service.customer.ICustomerService;
import com.case_study.service.employee.IEmployeeService;
import com.case_study.service.facility.IFacilityService;
import com.case_study.service.facility.IFacilityTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private IContractService contractService;

    @Autowired
    private IFacilityService facilityService;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IEmployeeService employeeService;

    @GetMapping
    public String showList(@PageableDefault(value = 5)Pageable pageable,
                           Model model){
        model.addAttribute("contractPage",contractService.findAll(pageable));
        return "/contract/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model ){
        model.addAttribute("facilityList",facilityService.facilityList());
        model.addAttribute("employeeList",employeeService.findAll());
        model.addAttribute("customerList",customerService.customerList());
        model.addAttribute("contractList", new ContractDto());
        return "/contract/create";
    }

    @PostMapping("/save")
    private String save(ContractDto contractDto , RedirectAttributes redirect){
        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDto,contract);
        contractService.save(contract);
        redirect.addFlashAttribute("mess","Thêm mới thành công !");
        return "redirect:/contract";
    }

}
