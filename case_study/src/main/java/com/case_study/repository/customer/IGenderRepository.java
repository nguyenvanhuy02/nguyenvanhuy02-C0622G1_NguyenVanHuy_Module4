package com.case_study.repository.customer;

import com.case_study.model.customer.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGenderRepository extends JpaRepository<Gender,Integer> {
}
