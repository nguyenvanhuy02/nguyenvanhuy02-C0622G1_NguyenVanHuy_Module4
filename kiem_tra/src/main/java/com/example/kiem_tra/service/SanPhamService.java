package com.example.kiem_tra.service;

import com.example.kiem_tra.model.SanPham;
import com.example.kiem_tra.repository.ISanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SanPhamService implements ISanPhamService{

    @Autowired
    private ISanPhamRepository sanPhamRepository;
    @Override
    public List<SanPham> findAll() {
        return sanPhamRepository.findAll();
    }
}
