package com.example.kiem_tra.model;

import javax.persistence.*;

@Entity
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maSP;

    private String tenSP;

    private Integer giaSP;

    private String tinhTrangSP;

    @ManyToOne
    @JoinColumn(name = "loai_san_pham_id",referencedColumnName = "maLoaiSP")
    private LoaiSanPham loaiSanPham;

    public SanPham() {
    }

    public int getMaSP() {
        return maSP;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public Integer getGiaSP() {
        return giaSP;
    }

    public void setGiaSP(Integer giaSP) {
        this.giaSP = giaSP;
    }

    public String getTinhTrangSP() {
        return tinhTrangSP;
    }

    public void setTinhTrangSP(String tinhTrangSP) {
        this.tinhTrangSP = tinhTrangSP;
    }

    public LoaiSanPham getLoaiSanPham() {
        return loaiSanPham;
    }

    public void setLoaiSanPham(LoaiSanPham loaiSanPham) {
        this.loaiSanPham = loaiSanPham;
    }
}
