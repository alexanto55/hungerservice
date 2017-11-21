package com.hunger.main.controller;

import com.hunger.DAO.PaymentResource;
import com.hunger.bean.*;
import com.hunger.service.ConvertJSON;
import com.hunger.service.ItemService;
import com.hunger.utility.OrderException;
import com.hunger.utility.PaymentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping("/hunger")
public class ItemController {
    ItemService itemService;
    ConvertJSON convertJson;
    ResponseList responseList;

    public ItemController() throws IOException, GeneralSecurityException {
        itemService  = new ItemService();
        convertJson  = new ConvertJSON();
        responseList = new ResponseList();
    }

    @RequestMapping(value = "/{category}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public @ResponseBody String fetchMenuList(@PathVariable String category) throws IOException, GeneralSecurityException {

        ArrayList<ItemList> itemList = this.itemService.fetchMenuService(category);
        return this.convertJson.BuildJSON(itemList).toString();
    }

    @RequestMapping(value = "/crtorder",method =RequestMethod.POST )
    public ResponseEntity payment(@RequestBody OrderRequest orderRequest) throws IOException,GeneralSecurityException {

        try {
            /** Verify Order request details with Database
            **/
            itemService.verifyOrderRequest(orderRequest);

        } catch (PaymentException m) {
            m.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(this.responseList.paymentFailure(m.getMessage()));
        } catch (OrderException m) {
            m.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(this.responseList.orderFailure(m.getMessage()));
        }
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
