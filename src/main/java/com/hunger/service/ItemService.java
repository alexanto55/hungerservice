package com.hunger.service;

import com.google.api.services.bigquery.model.GetQueryResultsResponse;
import com.google.api.services.bigquery.model.TableCell;
import com.google.api.services.bigquery.model.TableRow;
import com.hunger.DAO.ItemDAO;
import com.hunger.bean.ItemList;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;

public class ItemService {

    public ArrayList<ItemList> fetchMenuService(String category) throws IOException, GeneralSecurityException {
        ItemDAO itemDAO = new ItemDAO();
        ArrayList<ItemList> itemArrayList = new ArrayList<ItemList>();

        GetQueryResultsResponse results = itemDAO.fetchMenuListDAO(category);
        if (results.getTotalRows() != null && results.getTotalRows().intValue() > 0) {
            for (TableRow rows: results.getRows()) {
                ItemList itemList = new ItemList();
                int cellCount = 0;
                for (TableCell cell: rows.getF()) {
                    switch (cellCount) {
                        case 0: itemList.setItemId(cell.getV().toString());
                            break;
                        case 1: itemList.setItemName(cell.getV().toString());
                            break;
                        case 2: itemList.setItemDesc(cell.getV().toString());
                            break;
                        case 3: itemList.setPrice(cell.getV().toString());
                            break;
                    }
                    cellCount++;
                }
                itemArrayList.add(itemList);
            }
            return itemArrayList;
        } else {
            return itemArrayList;
        }
    }
}
