package com.case_study.service.impl.facility;

import com.case_study.model.facility.Facility;
import com.case_study.repository.facility.IFacilityRepository;
import com.case_study.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FacilityService implements IFacilityService {

    @Autowired
    private IFacilityRepository facilityRepository;


    @Override
    public Page<Facility> findAll(String nameSearch, String facilityType, Pageable pageable) {
        return facilityRepository.findAllByNameAndType(nameSearch,facilityType,pageable);
    }

    @Override
    public void save(Facility facility) {
        facilityRepository.save(facility);
    }

    @Override
    public Facility findById(Integer id) {
        return facilityRepository.findById(id).orElse(null);
    }
}
