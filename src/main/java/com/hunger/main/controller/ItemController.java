package com.hunger.main.controller;

import com.hunger.DAO.PaymentResource;
import com.hunger.bean.*;
import com.hunger.service.ConvertJSON;
import com.hunger.service.ItemService;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping("/hunger")
public class ItemController {
    ItemService itemService = new ItemService();
    ConvertJSON convertJson = new ConvertJSON();

    @RequestMapping(value = "/{category}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public @ResponseBody String fetchMenuList(@PathVariable String category) throws IOException, GeneralSecurityException {

        ArrayList<ItemList> itemList = itemService.fetchMenuService(category);
        return convertJson.BuildJSON(itemList).toString();
    }

   /* @RequestMapping(value ="/crtorder", method = RequestMethod.POST, consumes = "application/json")
    public OrderRequest createOrder(@RequestBody OrderRequest orderRequest) {
        itemService.createOrder(orderRequest);
        return orderRequest;
    }*/

    @RequestMapping(value = "/crtorder",method =RequestMethod.POST )
    public void payment(@RequestBody OrderRequest orderRequest) throws IOException,GeneralSecurityException{
        PaymentResource paymentResource = new PaymentResource();
        paymentResource.getPaymentDetails(orderRequest);


    }
}
