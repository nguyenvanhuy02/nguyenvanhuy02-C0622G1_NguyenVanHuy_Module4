package com.example.service;

import com.example.model.NhaXe;
import com.example.repository.INhaXeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NhaXeService implements INhaXeService{

    @Autowired
    private INhaXeRepository nhaXeRepository;

    @Override
    public List<NhaXe> getListNhaXe() {
        return nhaXeRepository.findAll();
    }

    @Override
    public void save(NhaXe nhaXe) {
        nhaXeRepository.save(nhaXe);
    }

    @Override
    public Optional<NhaXe> findById(int id) {
        return nhaXeRepository.findById(id);
    }

    @Override
    public void remove(int id) {
        nhaXeRepository.deleteById(id);
    }
}
