package com.hunger.service;

import com.google.api.services.bigquery.model.GetQueryResultsResponse;
import com.google.api.services.bigquery.model.TableCell;
import com.hunger.DAO.CustomerDAO;
import com.hunger.bean.ResponseMessage;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;

import com.google.api.services.bigquery.model.TableRow;

@Service
public class CustomerService {

    public Boolean validateCustomer(String userName, String pwd) throws IOException, GeneralSecurityException{
        CustomerDAO customerDAO = new CustomerDAO();
        GetQueryResultsResponse results = customerDAO.loginValidateDAO(userName, pwd);

        if (results.getTotalRows() != null && results.getTotalRows().intValue() > 0) {
            return true;
        } else {
            return false;
        }
    }
}
