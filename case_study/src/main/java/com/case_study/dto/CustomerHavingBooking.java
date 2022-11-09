package com.case_study.dto;

public interface CustomerHavingBooking {
    String getCustomerId();
    String getCustomerName();
    String getFacilityName();
    String getStartDate();
    String getEndDate();
    String total();
}
