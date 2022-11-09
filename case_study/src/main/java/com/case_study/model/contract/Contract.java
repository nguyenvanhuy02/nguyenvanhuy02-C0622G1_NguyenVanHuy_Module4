package com.case_study.model.contract;

import com.case_study.model.customer.Customer;
import com.case_study.model.employee.Employee;
import com.case_study.model.facility.Facility;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String start_date;

    private String endDate;

    private Double deposit;
    @Column(name = "status", columnDefinition = "int default 1")
    private Integer status;

    @OneToMany(mappedBy = "contract")
    private Set<ContractDetail>contractDetails;

    @ManyToOne
    @JoinColumn(name = "employee_id",referencedColumnName = "id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "customer_id",referencedColumnName = "id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "facility_id",referencedColumnName = "id")
    private Facility facility;

    public Contract() {
    }

    public Contract(int id, String start_date, String endDate, Double deposit, Set<ContractDetail> contractDetails, Employee employee, Customer customer, Facility facility) {
        this.id = id;
        this.start_date = start_date;
        this.endDate = endDate;
        this.deposit = deposit;
        this.contractDetails = contractDetails;
        this.employee = employee;
        this.customer = customer;
        this.facility = facility;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public Set<ContractDetail> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(Set<ContractDetail> contractDetails) {
        this.contractDetails = contractDetails;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
