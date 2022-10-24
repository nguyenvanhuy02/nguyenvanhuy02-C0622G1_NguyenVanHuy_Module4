package com.example.validating_form_input.controller;


import com.example.validating_form_input.dto.UserDto;
import com.example.validating_form_input.model.User;
import com.example.validating_form_input.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {
    @Autowired
    IUserService userService;

    @GetMapping("/list")
    public String showList(Model model){
        model.addAttribute("userList",userService.findAll());
        return "/form_input/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("userDto",new UserDto());
        return "/form_input/create";
    }
    @PostMapping("/save")
    public String save(@Validated @ModelAttribute("") UserDto userDto,
                       BindingResult bindingResult, RedirectAttributes redirect){
        new UserDto().validate(userDto,bindingResult);
        if (bindingResult.hasFieldErrors()){
            return "/form_input/create";
        }else {
            /*Copy dto sang entity */
            User user = new User();
            BeanUtils.copyProperties(userDto,user);
            userService.save(user);
            redirect.addFlashAttribute("mess","Thêm mới thành công!");
            return "redirect:/list";
        }
    }
}
