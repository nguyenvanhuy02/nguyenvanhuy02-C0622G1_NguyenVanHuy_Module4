package com.example.dto;

public class NhaXeDto {
    private int id;
    private String tenNhaXe;

    public NhaXeDto() {
    }

    public NhaXeDto(int id, String tenNhaXe) {
        this.id = id;
        this.tenNhaXe = tenNhaXe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenNhaXe() {
        return tenNhaXe;
    }

    public void setTenNhaXe(String tenNhaXe) {
        this.tenNhaXe = tenNhaXe;
    }
}
