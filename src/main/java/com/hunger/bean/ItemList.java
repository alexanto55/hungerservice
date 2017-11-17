package com.hunger.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ItemList {

    @JsonProperty("item_id")
    private String itemId;
    @JsonProperty("item")
    private String itemName;
    @JsonProperty("item_desc")
    private String itemDesc;
    @JsonProperty("unit_price")
    private String price;
    @JsonProperty("qty")
    private int qty;
    @JsonProperty("item_avail")
    private String itemAvail;
    @JsonProperty("item_catgry")
    private String itemCategory;

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getItemAvail() {
        return itemAvail;
    }

    public void setItemAvail(String itemAvail) {
        this.itemAvail = itemAvail;
    }

    public String getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}
