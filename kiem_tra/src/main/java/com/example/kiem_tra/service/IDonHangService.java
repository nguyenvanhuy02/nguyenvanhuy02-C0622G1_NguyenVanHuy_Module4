package com.example.kiem_tra.service;

import com.example.kiem_tra.model.DonHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IDonHangService {
    Page<DonHang> findAll(Pageable pageable);
    DonHang findById(int maDonHang);
    void save(DonHang donHang);
}
