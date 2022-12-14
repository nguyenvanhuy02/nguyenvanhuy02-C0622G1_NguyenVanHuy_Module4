package com.case_study.controller;

import com.case_study.dto.FacilityDto;
import com.case_study.model.facility.Facility;
import com.case_study.service.facility.IFacilityService;
import com.case_study.service.facility.IFacilityTypeService;
import com.case_study.service.facility.IRentTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        model.addAttribute("name",name);
        model.addAttribute("facilityType",facilityType);
        model.addAttribute("facilityTypeList",facilityTypeService.findAll());
        model.addAttribute("facilityPage",facilityService.findAll(name,facilityType, pageable));
        return "/facility/list";
    }


    @GetMapping("/create/villa")
    public String showCreateVilla(Model model){
        model.addAttribute("facilityDto",new FacilityDto());
        model.addAttribute("facilityTypeList",facilityTypeService.findAll());
        model.addAttribute("rentTypeList",rentTypeService.findAll());
        return "/facility/create_villa";
    }

    @GetMapping("/create/house")
    public String showCreateHouse(Model model){
        model.addAttribute("facilityDto",new FacilityDto());
        model.addAttribute("facilityTypeList",facilityTypeService.findAll());
        model.addAttribute("rentTypeList",rentTypeService.findAll());
        return "/facility/create_house";
    }

    @GetMapping("/create/room")
    public String showCreateRoom(Model model){
        model.addAttribute("facilityDto",new FacilityDto());
        model.addAttribute("facilityTypeList",facilityTypeService.findAll());
        model.addAttribute("rentTypeList",rentTypeService.findAll());
        return "/facility/create_room";
    }

    @PostMapping("/save")
    public String save(@Validated @ModelAttribute("") FacilityDto facilityDto ,
                       BindingResult bindingResult, RedirectAttributes redirect,
                       Model model){
        model.addAttribute("facilityTypeList",facilityTypeService.findAll());
        model.addAttribute("rentTypeList",rentTypeService.findAll());
        new FacilityDto().validate(facilityDto,bindingResult);
        if (bindingResult.hasFieldErrors()){
            if (facilityDto.getFacilityType().getId() == 1){
                return "/facility/create_villa";
            }
            if (facilityDto.getFacilityType().getId() == 2){
                return "/facility/create_house";
            }
            if (facilityDto.getFacilityType().getId() == 3){
                return "/facility/create_room";
            }
        }
        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDto,facility);
        facilityService.save(facility);
        redirect.addFlashAttribute("mess","Th??m m???i th??nh c??ng !");
        return "redirect:/facility";
    }

    @GetMapping("/{id}/edit")
    public String edit (@PathVariable int id, Model model){
        model.addAttribute("facilityTypeList",facilityTypeService.findAll());
        model.addAttribute("rentTypeList",rentTypeService.findAll());
        model.addAttribute("facilityDto",facilityService.findById(id));
        return "/facility/edit";
    }

    @PostMapping("/update")
    public String update(FacilityDto facilityDto, RedirectAttributes redirect){
        Facility facility= new Facility();
        BeanUtils.copyProperties(facilityDto,facility);
        facilityService.save(facility);
        redirect.addFlashAttribute("mess","Ch???nh s???a th??nh c??ng !");
        return "redirect:/facility";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id , RedirectAttributes redirect ){
        Facility facility = facilityService.findById(id);
        facility.setStatus(0);
        facilityService.save(facility);
        redirect.addFlashAttribute("mess","Xo?? th??nh c??ng !");
        return "redirect:/facility";
    }

    @GetMapping("/{id}/view")
    public String viewFacility(@PathVariable int id , Model model){
        model.addAttribute("facility",facilityService.findById(id));
        return "/facility/view";
    }
}
