package com.example.demo.repository;

import com.example.demo.model.ClassStudent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClassStudent extends JpaRepository<ClassStudent,Integer> {
}
