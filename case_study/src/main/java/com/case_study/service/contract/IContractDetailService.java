package com.case_study.service.contract;

import com.case_study.model.contract.ContractDetail;

import java.util.List;

public interface IContractDetailService {
    List<ContractDetail> findAll(Integer customerId);
}
