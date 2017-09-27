package com.hunger.service;

import com.google.api.services.bigquery.model.GetQueryResultsResponse;
import com.hunger.DAO.CustomerDAO;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;

@Service
public class CustomerService {

    public boolean validateCustomer(String userName, String pwd) throws IOException, GeneralSecurityException{
        CustomerDAO customerDAO = new CustomerDAO();
        GetQueryResultsResponse results = customerDAO.loginValidateDAO(userName, pwd);

        if (results.getTotalRows() != null && results.getTotalRows().intValue() > 0) {
            return true;
        } else {
            return false;
        }
    }
}
