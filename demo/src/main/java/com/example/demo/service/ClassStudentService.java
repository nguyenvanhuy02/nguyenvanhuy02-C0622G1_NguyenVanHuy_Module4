package com.example.demo.service;

import com.example.demo.model.ClassStudent;
import com.example.demo.repository.IClassStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassStudentService implements IClassStudentService {
    @Autowired
    private IClassStudent classStudent;
    @Override
    public List<ClassStudent> findAll() {
        return classStudent.findAll();
    }
}
