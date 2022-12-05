package com.example.repository;

import com.example.model.VeXe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IVeXeRepository extends JpaRepository<VeXe, Integer> {

    @Query(value = "select* from ve_xe " +
            "where trang_thai = true " +
            "order by id desc", nativeQuery = true)
    List<VeXe> findAll();


    @Query(value = "select* from ve_xe " +
            "where trang_thai = true " +
            "and id= :id", nativeQuery = true)
      VeXe findById(@Param("id") int id);

    @Query(value = "select* from ve_xe " +
            "where diem_di like %:diemDi% " +
            "and diem_den like %:diemDen% " +
            "and date(ngay_khoi_hanh) " +
            "between date(:ngayBatDau) " +
            "and date(:ngayKetThuc) " +
            "and trang_thai = true", nativeQuery = true)
    List<VeXe> search(
            @Param("diemDi") String diemDi,
            @Param("diemDen") String diemDen,
            @Param("ngayBatDau") String ngayBatDau,
            @Param("ngayKetThuc") String ngayKetThuc);

}
