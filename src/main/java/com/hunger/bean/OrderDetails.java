package com.hunger.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class OrderDetails {

    @JsonProperty("orderTotal")
    private String orderTotal;
    @JsonProperty("orderSubTotal")
    private String orderSubTotal;
    @JsonProperty("taxAmount")
    private String taxAmount;

    @JsonProperty("customerDetails")
    private CustomerInfo customerDetails;
    @JsonProperty("paymentDetails")
    private PaymentInfo paymentDetails;
    @JsonProperty("items")
    private ArrayList<OrderItems> items;

    public ArrayList<OrderItems> getItems() {
        return items;
    }

    public void setItems(ArrayList<OrderItems> items) {
        this.items = items;
    }

    public String getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(String orderTotal) {
        this.orderTotal = orderTotal;
    }

    public String getOrderSubTotal() {
        return orderSubTotal;
    }

    public void setOrderSubTotal(String orderSubTotal) {
        this.orderSubTotal = orderSubTotal;
    }

    public String getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(String taxAmount) {
        this.taxAmount = taxAmount;
    }

    public CustomerInfo getCustomerDetails() {
       return customerDetails;
    }

    public void setCustomerDetails(CustomerInfo customerDetails) {
        this.customerDetails = customerDetails;
    }

    public PaymentInfo getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(PaymentInfo paymentDetails) {
        this.paymentDetails = paymentDetails;
    }
}
