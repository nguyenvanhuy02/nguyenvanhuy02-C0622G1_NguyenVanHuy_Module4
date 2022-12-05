package com.example.kiem_tra.repository;

import com.example.kiem_tra.model.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISanPhamRepository extends JpaRepository<SanPham,Integer> {
}
