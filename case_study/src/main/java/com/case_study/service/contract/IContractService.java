package com.case_study.service.contract;

import com.case_study.dto.CustomerHavingBooking;
import com.case_study.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractService {
    Page<Contract> findAll(Pageable pageable);

    void save(Contract contract);

    Page<CustomerHavingBooking> findAllCustomerUseContract(Pageable pageable);
    List<CustomerHavingBooking> findAllCustomerUseContract1();
}
