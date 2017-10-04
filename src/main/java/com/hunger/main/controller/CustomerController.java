package com.hunger.main.controller;

import com.hunger.bean.ResponseList;
import com.hunger.bean.ResponseMessage;
import com.hunger.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/hunger")
public class CustomerController {

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String helloWorld() {
        return "Hi...How are you?";
    }

    @RequestMapping(value = "/login/userName={userName}&&pwd={pwd}",
            method = RequestMethod.GET,
            produces = "application/json;charset=UTF-8")
    public @ResponseBody ResponseList loginApp(@PathVariable Map<String,String> pathVars)
            throws IOException, GeneralSecurityException{

        String userName = pathVars.get("userName");
        String pwd = pathVars.get("pwd");

        CustomerService customerService = new CustomerService();
        ResponseList responseList = new ResponseList();

        Boolean loginResult = customerService.validateCustomer(userName, pwd);

        if (!loginResult) {
            responseList.failureMessage();
        } else {
            responseList.successMessage();
        }
        return responseList;
    }
}