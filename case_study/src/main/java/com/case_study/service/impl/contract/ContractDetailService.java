package com.case_study.service.impl.contract;

import com.case_study.model.contract.ContractDetail;
import com.case_study.repository.contract.IContractDetailRepository;
import com.case_study.service.contract.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailService implements IContractDetailService {
    @Autowired
    private IContractDetailRepository contractDetailRepository;

    @Override
    public List<ContractDetail> findAll(Integer customerId) {
        return contractDetailRepository.findByCustomerId(customerId);
    }
}
