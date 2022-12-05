package com.example.controller;

import com.example.model.NhaXe;
import com.example.model.VeXe;
import com.example.service.INhaXeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("nha")
public class NhaXeRestController {
    @Autowired
    private INhaXeService nhaXeService;

    @GetMapping
    public ResponseEntity<List<NhaXe>> getVeXeList() {
        List<NhaXe> nhaXeList = nhaXeService.getListNhaXe();
        if (nhaXeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(nhaXeList, HttpStatus.OK);
    }
}
