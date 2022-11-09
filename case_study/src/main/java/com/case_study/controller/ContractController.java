package com.case_study.controller;

import com.case_study.dto.ContractDto;
import com.case_study.dto.CustomerHavingBooking;
import com.case_study.model.contract.Contract;
import com.case_study.model.contract.ContractDetail;
import com.case_study.service.contract.IContractDetailService;
import com.case_study.service.contract.IContractService;
import com.case_study.service.customer.ICustomerService;
import com.case_study.service.employee.IEmployeeService;
import com.case_study.service.facility.IFacilityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

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

    @Autowired
    private IContractDetailService contractDetailService;


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

    @GetMapping("/list")
    private String listContract(@PageableDefault(value = 2) Pageable pageable,
                                Model model){
        Page<CustomerHavingBooking> contractPages = contractService.findAllCustomerUseContract(pageable);
        model.addAttribute("listContract", contractPages);
        return "/contract/list_contract";
    }

    @GetMapping("/list-facility/{customerId}")
    public String listAttachFacility(@PathVariable int customerId,
                                     Model model){
        List<ContractDetail> contractDetails = contractDetailService.findAll(customerId);
        model.addAttribute("contractDetails",contractDetails);
        return "/contract/use";
    }
}
