package com.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class NhaXe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String tenNhaXe;

    @JsonBackReference
    @OneToMany(mappedBy = "nhaXe")
    private Set<VeXe> veXeSet;

    public NhaXe() {
    }

    public NhaXe(int id, String tenNhaXe, Set<VeXe> veXeSet) {
        this.id = id;
        this.tenNhaXe = tenNhaXe;
        this.veXeSet = veXeSet;
    }

    public NhaXe(int id, String tenNhaXe) {
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

    public Set<VeXe> getVeXeSet() {
        return veXeSet;
    }

    public void setVeXeSet(Set<VeXe> veXeSet) {
        this.veXeSet = veXeSet;
    }
}
