package com.hunger.main.controller;

import com.hunger.bean.ResponseMessage;
import com.hunger.service.CustomerService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Map;

@RestController
@RequestMapping("/hunger")
public class CustomerController {

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String helloWorld() {
        return "Hi...How are you?";
    }

    @RequestMapping(value = "/login/userName={userName}&&pwd={pwd}", method = RequestMethod.GET)
    public ResponseMessage loginApp(@PathVariable Map<String,String> pathVars) throws IOException, GeneralSecurityException{

        String userName = pathVars.get("userName");
        String pwd = pathVars.get("pwd");

        ResponseMessage responseMessage = new ResponseMessage();
        CustomerService customerService = new CustomerService();

        Boolean loginResult = customerService.validateCustomer(userName, pwd);

        if (loginResult) {
            responseMessage.setResponseCode("200");
            responseMessage.setResponseMessage("Success");
            responseMessage.setResponseDesc("Valid user name and password");
        } else {
            responseMessage.setResponseCode("400");
            responseMessage.setResponseMessage("Fail");
            responseMessage.setResponseDesc("Invalid user name and password");
        }
        return responseMessage;
    }
}
