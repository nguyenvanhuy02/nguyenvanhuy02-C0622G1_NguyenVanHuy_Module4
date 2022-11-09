package com.case_study.repository.contract;

import com.case_study.dto.CustomerHavingBooking;
import com.case_study.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IContractRepository extends JpaRepository<Contract, Integer> {

//    @Query(value = "select c.name customerName, f.name facilityname, ct.start_date startDate,ct.end_date endDate from `customer` c join `contract` ct on c.id = ct.customer_id join `facility` f on ct.facility_id = f.id where ct.status = 1 order by c.name",
//            nativeQuery = true,
//            countQuery = "select c.name customerName, f.name facilityname, ct.start_date startDate,ct.end_date endDate from `customer` c join `contract` ct on c.id = ct.customer_id join `facility` f on ct.facility_id = f.id where ct.status = 1 order by c.name")
//    Page<CustomerHavingBooking> findAllCustomerUseContract(Pageable pageable);


    @Query(value = "select customer.id customerId, customer.name customerName,contract.start_date startDate,contract.end_date endDate,GROUP_CONCAT(facility.name) as facilityName from `contract` join customer on contract.customer_id = customer.id join `facility` on contract.facility_id = facility.id group by customer.name ", nativeQuery = true)
    Page<CustomerHavingBooking> findAllCustomerUseContract(Pageable pageable);

    @Query(value =
            "select c.name customerName, f.name facilityname, ct.start_date startDate,ct.end_date endDate from `customer` c join `contract` ct on c.id = ct.customer_id join `facility` f on ct.facility_id = f.id where ct.status = 1 order by c.name;"
            , nativeQuery = true)
    List<CustomerHavingBooking> findAllCustomerUseContract1();
}
