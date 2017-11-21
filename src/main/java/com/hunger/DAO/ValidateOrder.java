package com.hunger.DAO;

import com.hunger.bean.OrderRequest;
import com.hunger.utility.OrderException;

public class ValidateOrder {

    public void validateOrderRequest(OrderRequest orderRequest) throws OrderException{
        throw new OrderException("Invalid Item ID");
    }
}
