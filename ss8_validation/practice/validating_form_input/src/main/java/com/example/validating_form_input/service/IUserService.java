package com.example.validating_form_input.service;

import com.example.validating_form_input.model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    void save(User user);
}
