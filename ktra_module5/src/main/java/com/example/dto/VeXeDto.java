package com.example.dto;

import com.example.model.NhaXe;

public class VeXeDto {
    private int id;
    private Integer giaVe;
    private String diemDi;
    private String diemDen;
    private String ngayKhoiHanh;
    private String gioKhoiHang;
    private Integer soLuong;
    private NhaXe nhaXe;

    public VeXeDto() {
    }

    public VeXeDto(int id, Integer giaVe, String diemDi, String diemDen, String ngayKhoiHanh, String gioKhoiHang, Integer soLuong, NhaXe nhaXe) {
        this.id = id;
        this.giaVe = giaVe;
        this.diemDi = diemDi;
        this.diemDen = diemDen;
        this.ngayKhoiHanh = ngayKhoiHanh;
        this.gioKhoiHang = gioKhoiHang;
        this.soLuong = soLuong;
        this.nhaXe = nhaXe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getGiaVe() {
        return giaVe;
    }

    public void setGiaVe(Integer giaVe) {
        this.giaVe = giaVe;
    }

    public String getDiemDi() {
        return diemDi;
    }

    public void setDiemDi(String diemDi) {
        this.diemDi = diemDi;
    }

    public String getDiemDen() {
        return diemDen;
    }

    public void setDiemDen(String diemDen) {
        this.diemDen = diemDen;
    }

    public String getNgayKhoiHanh() {
        return ngayKhoiHanh;
    }

    public void setNgayKhoiHanh(String ngayKhoiHanh) {
        this.ngayKhoiHanh = ngayKhoiHanh;
    }

    public String getGioKhoiHang() {
        return gioKhoiHang;
    }

    public void setGioKhoiHang(String gioKhoiHang) {
        this.gioKhoiHang = gioKhoiHang;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public NhaXe getNhaXe() {
        return nhaXe;
    }

    public void setNhaXe(NhaXe nhaXe) {
        this.nhaXe = nhaXe;
    }
}
