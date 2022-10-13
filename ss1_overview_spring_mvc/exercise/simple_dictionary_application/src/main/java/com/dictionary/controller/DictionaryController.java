package com.dictionary.controller;


import com.dictionary.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/")
public class DictionaryController {
    @Autowired
    private IDictionaryService dictionaryService;
    @GetMapping
    public String dicitonary(){
        return "/dictionary";
    }

    @PostMapping("/result")
    public String result(@RequestParam String english , Model model){
        String result = dictionaryService.search(english);
        model.addAttribute("result",result);
        return "/dictionary";
    }
}
