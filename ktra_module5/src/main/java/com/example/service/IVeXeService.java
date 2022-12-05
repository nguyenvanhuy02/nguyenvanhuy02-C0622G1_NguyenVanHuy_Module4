package com.example.service;

import com.example.model.VeXe;

import java.util.List;

public interface IVeXeService {

    List<VeXe> findAll();

    void save(VeXe veXe);

    VeXe findById(int id);

    void remove(int id);

    VeXe findByIdOptional(int id);

    List<VeXe> search(String diemDi, String diemDen, String ngayBatDau, String ngayKetThuc);

}
