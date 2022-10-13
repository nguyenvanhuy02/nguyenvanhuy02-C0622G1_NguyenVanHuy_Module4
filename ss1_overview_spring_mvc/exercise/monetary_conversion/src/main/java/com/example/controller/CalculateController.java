package com.example.controller;


import com.example.service.ICalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class CalculateController {

    @Autowired
    private ICalculateService calculateService;

    @GetMapping("")
    public String calculate() {
        return "/result";
    }

    @PostMapping("/result")
    public String result(@RequestParam int usd, Model model) {
        int result = calculateService.calculate(usd);
        model.addAttribute("result" , result);
        model.addAttribute("usd" , usd);
        return "/result";
    }
}
