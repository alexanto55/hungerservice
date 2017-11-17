package com.hunger.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderItems {

    @JsonProperty("itemId")
    private String itemId;
    @JsonProperty("itemQty")
    private String itemQty;
    @JsonProperty("itemPrice")
    private String itemPrice;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemQty() {
        return itemQty;
    }

    public void setItemQty(String itemQty) {
        this.itemQty = itemQty;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }
}
