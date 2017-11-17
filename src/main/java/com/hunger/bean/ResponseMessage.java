package com.hunger.bean;

public class ResponseMessage {

    private String responseCode;
    private String responseMessage;
    private String responseDesc;

    public ResponseMessage(String responseCode, String responseMessage, String responseDesc) {
        super();
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
        this.responseDesc = responseDesc;
    }

    public ResponseMessage() {

    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
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
