package com.example.validating_form_input.service.impl;


import com.example.validating_form_input.model.User;
import com.example.validating_form_input.repository.IUserRepository;
import com.example.validating_form_input.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
