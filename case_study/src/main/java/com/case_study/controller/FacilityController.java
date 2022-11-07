package com.case_study.controller;

import com.case_study.service.facility.IFacilityService;
import com.case_study.service.facility.IFacilityTypeService;
import com.case_study.service.facility.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/facility")
public class FacilityController {

    @Autowired
    private IFacilityService facilityService;

    @Autowired
    private IFacilityTypeService facilityTypeService;

    @Autowired
    private IRentTypeService rentTypeService;

    @GetMapping
    public String showList(@PageableDefault(value = 5) Pageable pageable ,
                            @RequestParam (value = "name" , defaultValue = "") String name,
                            @RequestParam (value = "facilityType" , defaultValue = "") String facilityType,
                             Model model){
        Sort sort = Sort.by("name").ascending();
        model.addAttribute("facilityTypeList",facilityTypeService.findAll());
        model.addAttribute("facilityPage",facilityService.findAll(name,facilityType, pageable));
        return "/facility/list";
    }


    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("facilityDto",facilityTypeService.findAll());
        return "/facility/create";
    }
}
