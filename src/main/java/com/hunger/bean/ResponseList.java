package com.hunger.bean;


import java.util.Arrays;
import java.util.List;

public class ResponseList {

    public List<ResponseMessage> successMessage() {
        return Arrays.asList(
                new ResponseMessage(200, "Success", "Service returned 200 reponse")
        );
    }

    public List<ResponseMessage> failureMessage() {
        return Arrays.asList(
                new ResponseMessage(400, "Failed", "Service Failed")
        );

    }

    public List<ResponseMessage> paymentFailure(String msg) {
        return Arrays.asList(
                new ResponseMessage(400, "Payment", msg)
        );
    }

    public List<ResponseMessage> orderFailure(String msg) {
        return Arrays.asList(
                new ResponseMessage(400, "OrderCreate", msg)
        );
    }
}
