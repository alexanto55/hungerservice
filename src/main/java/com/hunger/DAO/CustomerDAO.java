package com.hunger.DAO;

import com.google.api.services.bigquery.Bigquery;
import com.google.api.services.bigquery.model.GetQueryResultsResponse;
import com.google.api.services.bigquery.model.QueryRequest;
import com.google.api.services.bigquery.model.QueryResponse;
//import com.google.cloud.bigquery.QueryResponse;
//import com.google.cloud.bigquery.FieldValue;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class CustomerDAO {

    private static String ProjectID = "hunger-180002";

    public GetQueryResultsResponse loginValidateDAO(String userName, String pwd) throws IOException, GeneralSecurityException {

        String loginSQL = "SELECT * " +
                "FROM ProjectData.cust_info " +
                "where cust_user_name='"+userName+"' " +
                "and cust_login_pwd='"+pwd+"'";

        BigqueryTable bigqueryTable = new BigqueryTable();
        Bigquery bq = bigqueryTable.getBigquryTable();

        /** execute the query **/
        QueryResponse query = bq.jobs().query(ProjectID, new QueryRequest().setQuery(loginSQL)).execute();

//        for(FieldValue fieldValue: query) {
//
//        }

        /** Get the result **/
        GetQueryResultsResponse queryResults = bq.jobs().getQueryResults(
                query.getJobReference().getProjectId(),
                query.getJobReference().getJobId()).execute();

        return queryResults;
    }
}
