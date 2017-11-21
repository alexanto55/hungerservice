package com.hunger.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PaymentInfo {

    @JsonProperty("cardNumber")
    private String cardNumber;
    @JsonProperty("cardCVVNumber")
    private int cardCVVNumber;
    @JsonProperty("cardExpDate")
    private String cardExpDate;
    @JsonProperty("zipCode")
    private String zipcode;
    @JsonProperty("cardHolderFirstName")
    private String cardHolderFirstName;
    @JsonProperty("cardHolderLastName")
    private String cardHolderLastName;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getCardCVVNumber() {
        return cardCVVNumber;
    }

    public void setCardCVVNumber(int cardCVVNumber) {
        this.cardCVVNumber = cardCVVNumber;
    }

    public String getCardExpDate() {
        return cardExpDate;
    }

    public void setCardExpDate(String cardExpDate) {
        this.cardExpDate = cardExpDate;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCardHolderFirstName() {
        return cardHolderFirstName;
    }

    public void setCardHolderFirstName(String cardHolderFirstName) {
        this.cardHolderFirstName = cardHolderFirstName;
    }

    public String getCardHolderLastName() {
        return cardHolderLastName;
    }

    public void setCardHolderLastName(String cardHolderLastName) {
        this.cardHolderLastName = cardHolderLastName;
    }
}

