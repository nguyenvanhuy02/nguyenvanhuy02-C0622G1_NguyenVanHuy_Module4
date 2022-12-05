package com.example.service;

import com.example.model.NhaXe;

import java.util.List;
import java.util.Optional;

public interface INhaXeService {
    List<NhaXe> getListNhaXe();

    void save(NhaXe nhaXe);

    Optional<NhaXe> findById(int id);

    void remove(int id);

}
