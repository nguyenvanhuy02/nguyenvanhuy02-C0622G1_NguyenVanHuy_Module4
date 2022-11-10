package com.case_study.dto;

import com.case_study.model.facility.Facility;
import com.case_study.model.facility.FacilityType;
import com.case_study.model.facility.RentType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class FacilityDto implements Validator {

    private int id;
    @NotBlank(message = "Name not blank")
    private String name;

    private Integer area;
    @NotNull(message = "Cost not blank")
    private Double cost;

    private Integer maxPeople;

    private String standardRoom;

    private String descriptionOtherConvenience;

    private Double poolArea;

    private Integer numberOfFloors;

    private String facilityFree;
    @Column(name = "status", columnDefinition = "int default 1")
    private Integer status = 1;
    private RentType rentType;
    private FacilityType facilityType;

    public FacilityDto() {
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

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Integer getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(Integer maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public String getFacilityFree() {
        return facilityFree;
    }

    public void setFacilityFree(String facilityFree) {
        this.facilityFree = facilityFree;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }



    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        FacilityDto facilityDto = (FacilityDto) target;
        switch (facilityDto.getFacilityType().getId()) {
            //villa
            case 1:
                if (!facilityDto.getStandardRoom().matches("^[a-zA-Z_ÀÁÂÃÈÉÊẾÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêếìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ ]{5,50}$") && !facilityDto.getStandardRoom().equals("")) {
                    errors.rejectValue("standardRoom", "standardRoomFacility.forbidden", "Standard Room malformed !");
                }
                if (!facilityDto.getDescriptionOtherConvenience().matches("^[a-zA-Z_ÀÁÂÃÈÉÊẾÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêếìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ ]{5,50}$") && !facilityDto.getDescriptionOtherConvenience().equals("")) {
                    errors.rejectValue("descriptionOtherConvenience", "descriptionOtherConvenience.forbidden", "Description Other Convenience Room malformed !");
                }

                if (facilityDto.getPoolArea() == null){
                    errors.rejectValue("poolArea", "poolAreaFacility.forbidden", "Pool Area not blank");
                }else if (!(facilityDto.getPoolArea() > 0)) {
                    errors.rejectValue("poolArea", "poolArea.forbidden", "Pool Area malformed !");
                }

                if (facilityDto.getNumberOfFloors() == null){
                    errors.rejectValue("numberOfFloors", "numberOfFloorsFacility.forbidden", "Number Of Floors not blank");
                }else if (!(facilityDto.getNumberOfFloors() > 0)) {
                    errors.rejectValue("numberOfFloors", "numberOfFloorsFacility.forbidden", "Number Of Floors malformed !");
                }
                break;
            //house
            case 2:
                if (!facilityDto.getStandardRoom().matches("^[a-zA-Z_ÀÁÂÃÈÉÊẾÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêếìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ ]{5,50}$") && !facilityDto.getStandardRoom().equals("")) {
                    errors.rejectValue("standardRoom", "standardRoomFacility.forbidden", "Standard Room malformed !");
                }

                if (!facilityDto.getDescriptionOtherConvenience().matches("^[a-zA-Z_ÀÁÂÃÈÉÊẾÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêếìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ ]{5,50}$") && !facilityDto.getDescriptionOtherConvenience().equals("")) {
                    errors.rejectValue("descriptionOtherConvenience", "descriptionOtherConvenience.forbidden", "Description Other Convenience Room malformed !");
                }

                if (facilityDto.getNumberOfFloors() == null){
                    errors.rejectValue("numberOfFloors", "numberOfFloorsFacility.forbidden", "Number Of Floors not blank");
                }else if (!(facilityDto.getNumberOfFloors() > 0)) {
                    errors.rejectValue("numberOfFloors", "numberOfFloorsFacility.forbidden", "Number Of Floors malformed !");
                }
                break;
            //room
            case 3:
                if (facilityDto.facilityFree.equals("")) {
                    errors.rejectValue("facilityFree", "facilityFree.forbidden", "Facility Free cannot be left blank");
                }
                break;
        }

        if (!facilityDto.getName().matches("[a-zA-Z0-9]{5,50}") && !facilityDto.getName().equals("")) {
            errors.rejectValue("name", "nameFacility.forbidden", "Name malformed !");
        }

        if (facilityDto.getArea() == null) {
            errors.rejectValue("area", "areaFacility.forbidden", "Area not blank");
        } else if (facilityDto.area <= 0) {
            errors.rejectValue("area", "areaFacility.forbidden", "Area malformed !");
        }

        if (facilityDto.getCost() == null) {
            errors.rejectValue("cost", "costFacility.forbidden", "Cost not blank");
        } else if (!(facilityDto.getCost() > 0)) {
            errors.rejectValue("cost", "costFacility.forbidden", "Cost malformed !");
        }

        if (facilityDto.getMaxPeople() == null){
            errors.rejectValue("maxPeople", "maxPeopleFacility.forbidden", "Max People not blank");
        }else if (!(facilityDto.getMaxPeople() > 0)) {
            errors.rejectValue("maxPeople", "maxPeopleFacility.forbidden", "Max People malformed !");
        }











    }

}
