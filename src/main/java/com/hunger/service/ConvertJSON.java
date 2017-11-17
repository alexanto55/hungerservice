package com.hunger.service;

import com.hunger.bean.ItemList;
import com.hunger.bean.ResponseList;
import org.json.JSONObject;

import java.util.ArrayList;

public class ConvertJSON {

    /** convert into JSON object **/
    public JSONObject BuildJSON(ArrayList<ItemList> itemLists) {
        JSONObject obj = new JSONObject();
        ResponseList responseList = new ResponseList();
        /** verify the item list returned with DB results **/
        if (itemLists.isEmpty()) {
            obj.put("Response", responseList.failureMessage());
            obj.put("Items", itemLists);
        } else {
            obj.put("Response", responseList.successMessage());
            obj.put("Items", itemLists);
        }
        return obj;
    }
}
