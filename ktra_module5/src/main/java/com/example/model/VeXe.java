package com.example.model;

import javax.persistence.*;

@Entity
public class VeXe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Integer giaVe;
    private String diemDi;
    private String diemDen;
    private String ngayKhoiHanh;
    private String gioKhoiHang;
    private Integer soLuong;
    private boolean trangThai = true;

    @ManyToOne
    @JoinColumn(name = "nhaXe_id", referencedColumnName = "id")
    private NhaXe nhaXe;

    public VeXe() {
    }

    public VeXe(int id, Integer giaVe, String diemDi, String diemDen, String ngayKhoiHanh, String gioKhoiHang, Integer soLuong, boolean trangThai, NhaXe nhaXe) {
        this.id = id;
        this.giaVe = giaVe;
        this.diemDi = diemDi;
        this.diemDen = diemDen;
        this.ngayKhoiHanh = ngayKhoiHanh;
        this.gioKhoiHang = gioKhoiHang;
        this.soLuong = soLuong;
        this.trangThai = trangThai;
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

    public boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public NhaXe getNhaXe() {
        return nhaXe;
    }

    public void setNhaXe(NhaXe nhaXe) {
        this.nhaXe = nhaXe;
    }
}
