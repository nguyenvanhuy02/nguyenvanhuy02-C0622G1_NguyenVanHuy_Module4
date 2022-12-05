package com.example.demo.controller;

import com.example.demo.repository.IClassStudent;
import com.example.demo.service.IClassStudentService;
import com.example.demo.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @Autowired
    private IClassStudentService classStudentService;

    @GetMapping
    public String showList(@PageableDefault(value = 2)Pageable pageable ,
                           @RequestParam(value = "name",defaultValue = "") String name ,
                           @RequestParam (value = "nameClass",defaultValue = "") String nameClass,
                           Model model){
        model.addAttribute("name",name);
        model.addAttribute("nameClass",nameClass);
        model.addAttribute("classList",classStudentService.findAll());
        model.addAttribute("studentList",studentService.showList(name,nameClass,pageable));
        return "/stduent/list";
    }

}
