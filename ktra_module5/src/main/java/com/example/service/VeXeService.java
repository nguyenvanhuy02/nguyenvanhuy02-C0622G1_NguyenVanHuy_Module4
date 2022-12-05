package com.example.service;

import com.example.model.VeXe;
import com.example.repository.IVeXeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeXeService implements IVeXeService {

    @Autowired
    private IVeXeRepository veXeRepository;

    @Override
    public List<VeXe> findAll() {
        return veXeRepository.findAll();
    }

    @Override
    public void save(VeXe veXe) {
        veXeRepository.save(veXe);
    }

    @Override
    public VeXe findById(int id) {
        return veXeRepository.findById(id);
    }

    @Override
    public void remove(int id) {
        veXeRepository.deleteById(id);
    }

    @Override
    public VeXe findByIdOptional(int id) {
        return veXeRepository.findById(id);
    }

    @Override
    public List<VeXe> search(String diemDi, String diemDen, String ngayBatDau, String ngayKetThuc) {
        return veXeRepository.search(diemDi,diemDen,ngayBatDau,ngayKetThuc);
    }
}
