package com.example.kiem_tra.repository;

import com.example.kiem_tra.model.DonHang;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDonHangRepository extends JpaRepository<DonHang,Integer> {
}
