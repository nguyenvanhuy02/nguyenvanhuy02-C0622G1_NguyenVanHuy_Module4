package com.example.controller;

import com.example.dto.VeXeDto;
import com.example.model.VeXe;
import com.example.service.IVeXeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("ve")
public class VeXeRestController {
    @Autowired
    private IVeXeService veXeService;

    @GetMapping
    public ResponseEntity<List<VeXe>> getVeXeList() {
        List<VeXe> veXeList = veXeService.findAll();
        if (veXeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(veXeList, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<VeXe>> search(
            @RequestParam String diemDi,
            @RequestParam String diemDen,
            @RequestParam String ngayBatDau,
            @RequestParam String ngayKetThuc) {
        List<VeXe> veXeList = veXeService.search(diemDi, diemDen, ngayBatDau, ngayKetThuc);
        return new ResponseEntity<>(veXeList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveVeXe(@RequestBody VeXeDto veXeDto) {
        VeXe veXe = new VeXe();
        BeanUtils.copyProperties(veXeDto, veXe);
        veXeService.save(veXe);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/sua/{id}")
    public ResponseEntity<VeXe> updateVeXe(
            @PathVariable int id,
            @RequestBody VeXeDto veXeDto) {
        VeXe currentVeXe = veXeService.findById(id);
        if (currentVeXe == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        BeanUtils.copyProperties(veXeDto, currentVeXe);
        veXeService.save(currentVeXe);
        return new ResponseEntity<>(currentVeXe, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<VeXe> bookVeXe(
            @PathVariable int id,
            @RequestBody VeXeDto veXeDto) {
        VeXe currentVeXe = veXeService.findById(id);
        if (currentVeXe == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        currentVeXe.setSoLuong(currentVeXe.getSoLuong() - 1);
        BeanUtils.copyProperties(veXeDto, currentVeXe);
        veXeService.save(currentVeXe);
        return new ResponseEntity<>(currentVeXe, HttpStatus.OK);
    }

    @PutMapping("/xoa/{id}")
    public ResponseEntity<VeXe> deleteVeXe(
            @PathVariable int id,
            @RequestBody VeXeDto veXeDto) {
        VeXe currentVeXe = veXeService.findById(id);
        if (currentVeXe == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        currentVeXe.setTrangThai(false);
        BeanUtils.copyProperties(veXeDto, currentVeXe);
        veXeService.save(currentVeXe);
        return new ResponseEntity<>(currentVeXe, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VeXe> getVeXe(@PathVariable int id) {
        Optional<VeXe> veXeOptional = Optional.ofNullable(veXeService.findByIdOptional(id));
        if (!veXeOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(veXeOptional.get(), HttpStatus.OK);
    }

}
