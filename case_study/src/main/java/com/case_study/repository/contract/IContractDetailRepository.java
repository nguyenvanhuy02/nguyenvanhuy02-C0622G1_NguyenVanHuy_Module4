package com.case_study.repository.contract;

import com.case_study.model.contract.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IContractDetailRepository extends JpaRepository<ContractDetail,Integer> {
    @Query(value = "select cd.* from customer c join contract ct on c.id = ct.customer_id join contract_detail cd on cd.contract_id = ct.id join attach_facility af on cd.attach_facility_id = af.id where c.id =:customerId ", nativeQuery = true)
    List<ContractDetail> findByCustomerId(@Param("customerId") int customerId);
}
