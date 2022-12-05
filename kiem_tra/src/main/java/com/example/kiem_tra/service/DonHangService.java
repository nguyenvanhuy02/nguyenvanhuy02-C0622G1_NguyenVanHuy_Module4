package com.example.kiem_tra.service;

import com.example.kiem_tra.model.DonHang;
import com.example.kiem_tra.repository.IDonHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DonHangService implements IDonHangService{

    @Autowired
    private IDonHangRepository donHangRepository;

    @Override
    public Page<DonHang> findAll(Pageable pageable) {
        return donHangRepository.findAll(pageable);
    }

    @Override
    public DonHang findById(int maDonHang) {
        return donHangRepository.findById(maDonHang).orElse(null);
    }

    @Override
    public void save(DonHang donHang) {
        donHangRepository.save(donHang);
    }
}
