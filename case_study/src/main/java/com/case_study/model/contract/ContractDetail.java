package com.case_study.model.contract;

import javax.persistence.*;

@Entity
public class ContractDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "attach_facility_id",referencedColumnName = "id")
    private AttachFacility attachFacility;

    @ManyToOne
    @JoinColumn(name = "contract_id" , referencedColumnName = "id")
    private Contract contract;

    public ContractDetail() {
    }

    public ContractDetail(int id, Integer quantity, AttachFacility attachFacility, Contract contract) {
        this.id = id;
        this.quantity = quantity;
        this.attachFacility = attachFacility;
        this.contract = contract;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public AttachFacility getAttachFacility() {
        return attachFacility;
    }

    public void setAttachFacility(AttachFacility attachFacility) {
        this.attachFacility = attachFacility;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }
}
