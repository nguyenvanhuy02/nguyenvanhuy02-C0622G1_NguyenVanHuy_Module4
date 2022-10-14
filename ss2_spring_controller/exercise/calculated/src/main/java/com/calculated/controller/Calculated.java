package com.calculated.controller;


import com.calculated.service.ICalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Calculated {
    @Autowired
    ICalculator calculator;

    @GetMapping
    public String showCalculator(){
        return "/calculated";
    }

    @GetMapping("/result")
    public String calculate(@RequestParam (value = "numberOne") double numberOne,
                            @RequestParam(value = "numberTwo") double numberTow ,
                            @RequestParam (value = "calculation") String colculation , Model model){
        model.addAttribute("result",calculator.calculate(numberOne,numberTow,colculation));
        return "/calculated";
    }
}
