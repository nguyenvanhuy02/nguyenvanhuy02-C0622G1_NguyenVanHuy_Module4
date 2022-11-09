package com.case_study.service.impl.contract;

import com.case_study.dto.CustomerHavingBooking;
import com.case_study.model.contract.Contract;
import com.case_study.repository.contract.IContractRepository;
import com.case_study.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService implements IContractService {
    @Autowired
    private IContractRepository contractRepository;

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public Page<CustomerHavingBooking> findAllCustomerUseContract(Pageable pageable) {
        return contractRepository.findAllCustomerUseContract(pageable);
    }

    @Override
    public List<CustomerHavingBooking> findAllCustomerUseContract1() {
        return contractRepository.findAllCustomerUseContract1();
    }
}
