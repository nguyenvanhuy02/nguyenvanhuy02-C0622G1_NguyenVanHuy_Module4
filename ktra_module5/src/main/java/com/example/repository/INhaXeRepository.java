package com.example.repository;

import com.example.model.NhaXe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INhaXeRepository extends JpaRepository<NhaXe, Integer> {
}
