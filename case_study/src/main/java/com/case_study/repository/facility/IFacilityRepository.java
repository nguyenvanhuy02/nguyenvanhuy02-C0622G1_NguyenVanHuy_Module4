package com.case_study.repository.facility;

import com.case_study.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IFacilityRepository extends JpaRepository<Facility , Integer> {

    @Query(value = "select f.* from `facility` f join `facility_type` ft " +
            "on f.facility_type_id = ft.id " +
            "where f.name like %:name% and ft.name like %:type% and f.status= 1", nativeQuery = true)
    Page<Facility> findAllByNameAndType(@Param("name") String nameSearch,
                                        @Param("type")  String facilityType,
                                        Pageable pageable);
}
