package com.case_study.service.impl.customer;

import com.case_study.model.customer.Gender;
import com.case_study.repository.customer.IGenderRepository;
import com.case_study.service.customer.IGenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenderService implements IGenderService {

    @Autowired
    private IGenderRepository genderRepository;

    @Override
    public List<Gender> findAll() {
        return genderRepository.findAll();
    }
}
