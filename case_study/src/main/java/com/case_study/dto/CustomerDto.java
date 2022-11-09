package com.case_study.dto;

import com.case_study.model.contract.Contract;
import com.case_study.model.customer.CustomerType;
import com.case_study.model.customer.Gender;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Set;

public class CustomerDto implements Validator {

    private int id;
    @NotBlank(message = "Tên không được để trống !")
    private String name;
    @NotBlank(message = "Ngày sinh không được để trống !")
    private String dateOfBirth;
    @NotBlank(message = "Id card không được để trống !")
    private String idCard;
    @NotBlank(message = "Số điện thoại không được để trống !")
    private String phoneNumber;
    @NotBlank(message = "Email không được để trống !")
    private String email;
    @NotBlank(message = "Địa chỉ không được để trống !")
    private String address;

    private Integer status = 1;

    private Gender gender;

    private CustomerType customerType;

    private Set<Contract> contracts;

    public CustomerDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;

        if (!customerDto.getName().matches("^[a-zA-Z_ÀÁÂÃÈÉÊẾÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêếìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ ]{5,50}$") && !customerDto.getName().equals("")){
            errors.rejectValue("name","name.forbidden","Tên khách hàng không đúng định dạng !");
        }
        if (!customerDto.getIdCard().matches("[0-9]{12}") && !customerDto.getIdCard().equals("")){
            errors.rejectValue("idCard","idCard.forbidden","Id card malformed [X]{12} !");
        }
        if (!customerDto.getPhoneNumber().matches("[0][0-9]{9}") && !customerDto.getPhoneNumber().equals("")){
            errors.rejectValue("phoneNumber","phoneNumber.forbidden","Phone number malformed! (091XXXXXXX) ");
        }
        if (!customerDto.getEmail().matches("[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)") && !customerDto.getEmail().equals("")){
            errors.rejectValue("email","email.forbidden","Email malformed !");
        }
    }
}
