package com.example.service.impl;

import com.example.service.ICalculateService;
import org.springframework.stereotype.Service;


@Service
public class CalculateService implements ICalculateService {
    @Override
    public int calculate(int usd) {
        return usd * 22000;
    }
}
