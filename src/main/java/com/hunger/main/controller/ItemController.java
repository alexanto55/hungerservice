package com.hunger.main.controller;

import com.hunger.bean.ItemList;
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

    @RequestMapping(value = "/{category}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public @ResponseBody String fetchMenuList(@PathVariable String category) throws IOException, GeneralSecurityException {
        ItemService itemService = new ItemService();
        ConvertJSON convertJson = new ConvertJSON();

        ArrayList<ItemList> itemList = itemService.fetchMenuService(category);

        return convertJson.BuildJSON(itemList).toString();
    }
}
