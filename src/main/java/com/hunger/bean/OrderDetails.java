package com.hunger.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class OrderDetails {

    @JsonProperty("orderTotal")
    private double orderTotal;
    @JsonProperty("orderSubTotal")
    private double orderSubTotal;
    @JsonProperty("taxAmount")
    private double taxAmount;

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

    public double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public double getOrderSubTotal() {
        return orderSubTotal;
    }

    public void setOrderSubTotal(double orderSubTotal) {
        this.orderSubTotal = orderSubTotal;
    }

    public double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(double taxAmount) {
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
