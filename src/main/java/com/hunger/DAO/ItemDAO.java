package com.hunger.DAO;

import com.google.api.services.bigquery.Bigquery;
import com.google.api.services.bigquery.model.GetQueryResultsResponse;
import com.google.api.services.bigquery.model.QueryRequest;
import com.google.api.services.bigquery.model.QueryResponse;

import java.io.IOException;
import java.security.GeneralSecurityException;


public class ItemDAO {
    private static String ProjectID = "hunger-180002";
    public GetQueryResultsResponse fetchMenuListDAO(String category) throws IOException, GeneralSecurityException{

        String itemSQL = " SELECT TO_JSON_STRING(I) " +
                "FROM ProjectData.item I " +
                "INNER JOIN ProjectData.Item_Category IC " +
                "ON I.item_catgry = IC.Category_Code " +
                "WHERE item_catgry='"+category+"'";

        BigqueryTable bigqueryTable = new BigqueryTable();
        Bigquery bq = bigqueryTable.getBigquryTable();

        /** execute the query **/
        QueryResponse query = bq.jobs().query(ProjectID,
                new QueryRequest()
                        .setQuery(itemSQL)
                        .setUseLegacySql(false))
                .execute();

        /** Get the result **/
        GetQueryResultsResponse queryResults = bq.jobs().getQueryResults(
                query.getJobReference().getProjectId(),
                query.getJobReference().getJobId()).execute();

        return queryResults;
    }
}