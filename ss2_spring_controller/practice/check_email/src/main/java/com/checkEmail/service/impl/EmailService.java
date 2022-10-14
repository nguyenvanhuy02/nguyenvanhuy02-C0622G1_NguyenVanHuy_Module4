package com.checkEmail.service.impl;

import com.checkEmail.service.IEmailService;
import com.checkEmail.validation.Validation;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmailService implements IEmailService {
    @Override
    public Map<String, String> email(String email) {
        Map<String , String> errorMap = new HashMap<>();
        if ("".equals(email)){
            errorMap.put("email","Email không để trống");
        }else if (!Validation.checkEmail(email)){
            errorMap.put("email","Email không đúng định dạng");
        }
        if (errorMap.size()==0){
            errorMap.put("email" , "Email hợp lệ");
        }
        return errorMap;
    }
}
