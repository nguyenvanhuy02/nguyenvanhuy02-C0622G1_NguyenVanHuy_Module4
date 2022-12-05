package com.example.kiem_tra.service;

import com.example.kiem_tra.model.LoaiSanPham;
import com.example.kiem_tra.repository.ILoaiSanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LoaiSanPhamService implements ILoaiSanPhamService{

    @Autowired
    private ILoaiSanPhamRepository loaiSanPhamRepository;

    @Override
    public List<LoaiSanPham> findAll() {
        return loaiSanPhamRepository.findAll();
    }
}
