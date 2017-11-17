package com.hunger.service;

import com.google.api.services.bigquery.model.GetQueryResultsResponse;
import com.google.api.services.bigquery.model.TableCell;
import com.google.api.services.bigquery.model.TableRow;
import com.hunger.DAO.ItemDAO;
import com.hunger.bean.ItemList;
import com.hunger.bean.OrderRequest;
import org.json.JSONObject;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;

public class ItemService {

    public ArrayList<ItemList> fetchMenuService(String category) throws IOException, GeneralSecurityException {
        ItemDAO itemDAO = new ItemDAO();
        ArrayList<ItemList> itemArrayList = new ArrayList<ItemList>();

        GetQueryResultsResponse results = itemDAO.fetchMenuListDAO(category);
        /* Check whether  query result is not an empty list */
        if (results.getTotalRows() != null && results.getTotalRows().intValue() > 0) {
            for (TableRow rows: results.getRows()) { // Fetch rows from results
                ItemList itemList = new ItemList();
                for (TableCell cell: rows.getF()) {
                    String itemCell = cell.getV().toString();
                    /** Convert string object into JSONObject
                    *
                    */
                    JSONObject itemJson = new JSONObject(itemCell);
                    /* Assign each value into respective list parameter */
                    itemList.setItemId(itemJson.get("item_id").toString());
                    itemList.setItemName(itemJson.get("item").toString());
                    itemList.setPrice(itemJson.get("unit_price").toString());
                    itemList.setItemDesc(itemJson.get("item_desc").toString());
                }
                itemArrayList.add(itemList);
            }
            return itemArrayList;
        } else {
            return itemArrayList;
        }
    }

   /* public void createOrder(OrderRequest orderRequest) {
       OrderDAO orderDAO = new OrderDAO();
       ArrayList<OrderList>  createOrderList= new ArrayList<OrderList>();

       System.out.println(orderRequest.getOrderDetails().getOrderSubTotal());
    } */
}
