package com.checkEmail.validation;

public class Validation {
    public static boolean checkEmail(String email){
        String regexEmail = "[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)";
        return email.matches(regexEmail);
    }
}
