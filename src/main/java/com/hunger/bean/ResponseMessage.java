package com.hunger.bean;

public class ResponseMessage {

    private int responseCode;
    private String responseMessage;
    private String responseDesc;

    public ResponseMessage(int responseCode, String responseMessage, String responseDesc) {
        super();
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
        this.responseDesc = responseDesc;
    }

    public ResponseMessage() {

    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResponseDesc() {
        return responseDesc;
    }

    public void setResponseDesc(String responseDesc) {
        this.responseDesc = responseDesc;
    }

}
