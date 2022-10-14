package com.checkEmail.controller;

import com.checkEmail.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("/")
public class CheckEmail {

    @Autowired
    IEmailService emailService;

    @GetMapping
    public String checkEmail(){
        return "/checkEmail";
    }

    @PostMapping("/validate")
    String validateEmail(@RequestParam("email") String email, Model model){
        Map<String, String> email1 = emailService.email(email);

        model.addAttribute("email1",email1);
        return "/checkEmail";
    }
}
