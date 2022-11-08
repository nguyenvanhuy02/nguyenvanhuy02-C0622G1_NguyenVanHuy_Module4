package com.case_study.service.facility;

import com.case_study.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFacilityService {
    Page<Facility> findAll(String nameSearch , String facilityType, Pageable pageable);

    void save (Facility facility);

    Facility findById (Integer id);

    List<Facility> facilityList();
}
