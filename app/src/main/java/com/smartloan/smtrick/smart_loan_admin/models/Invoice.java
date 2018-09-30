package com.smartloan.smtrick.smart_loan_admin.models;

public class Invoice {
    private String name = "";
    private String cityState = "";
    private String phone = "";
    private String status = "";

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCityState(String cityState) {
        this.cityState = cityState;
    }

    public String getCityState() {
        return cityState;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
