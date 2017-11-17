package com.hunger.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerInfo {

    @JsonProperty("customerId")
    private String customerId;
    @JsonProperty("cusomterFirstName")
    private String cusomterFirstName;
    @JsonProperty("cusomterLastName")
    private String cusomterLastName;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCusomterFirstName() {
        return cusomterFirstName;
    }

    public void setCusomterFirstName(String cusomterFirstName) {
        this.cusomterFirstName = cusomterFirstName;
    }

    public String getCusomterLastName() {
        return cusomterLastName;
    }

    public void setCusomterLastName(String cusomterLastName) {
        this.cusomterLastName = cusomterLastName;
    }
}
