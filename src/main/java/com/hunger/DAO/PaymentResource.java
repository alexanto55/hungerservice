package com.hunger.DAO;

import com.google.api.services.bigquery.Bigquery;
import com.google.api.services.bigquery.model.QueryRequest;
import com.google.api.services.bigquery.model.QueryResponse;
import com.google.api.services.bigquery.model.TableCell;
import com.google.api.services.bigquery.model.TableRow;
import com.hunger.bean.OrderRequest;
import com.hunger.utility.PaymentException;
import org.json.JSONObject;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class PaymentResource {

    private String CARD_NBR;
    private int CVV;
    private String EXP_DT;
    private String ZIP_CODE;
    private String CUSTOMER_FN;
    private String CUSTOMER_LN;
    private String CUSTOMER_ID;
    private double ORDER_TOTAL;
    private static String ProjectID = "hunger-180002";
    private BigqueryTable bigqueryTable;
    private Bigquery bq;

    public PaymentResource() throws IOException,GeneralSecurityException {
        bigqueryTable = new BigqueryTable();
        bq = bigqueryTable.getBigquryTable();
    }

    public void getPaymentDetails(OrderRequest orderRequest) throws IOException,GeneralSecurityException, PaymentException {

        CARD_NBR = orderRequest.getOrderDetails().getPaymentDetails().getCardNumber();
        CVV = orderRequest.getOrderDetails().getPaymentDetails().getCardCVVNumber();
        EXP_DT = orderRequest.getOrderDetails().getPaymentDetails().getCardExpDate();
        ZIP_CODE = orderRequest.getOrderDetails().getPaymentDetails().getZipcode();
        CUSTOMER_FN = orderRequest.getOrderDetails().getPaymentDetails().getCardHolderFirstName();
        CUSTOMER_LN = orderRequest.getOrderDetails().getPaymentDetails().getCardHolderLastName();
        CUSTOMER_ID = orderRequest.getOrderDetails().getCustomerDetails().getCustomerId();
        ORDER_TOTAL = orderRequest.getOrderDetails().getOrderTotal();
    }

    public void verifyPaymentDetails(OrderRequest orderRequest) throws IOException, PaymentException, GeneralSecurityException {

        getPaymentDetails(orderRequest);

        String paymentSQL = "SELECT TO_JSON_STRING(I) " +
                "FROM ProjectData.payment_card_repo I " +
                "WHERE I.card_number ='"+CARD_NBR+"'";

        QueryResponse queryResponse = this.bq.jobs().query(ProjectID,
                new QueryRequest().setQuery(paymentSQL).setUseLegacySql(false)).execute();

        if ( queryResponse.getTotalRows().intValue() > 0 ) {
            for (TableRow rows:queryResponse.getRows()) {
                for (TableCell cell : rows.getF()) {
                   String cellValue = cell.getV().toString();
                    JSONObject jsonObject = new JSONObject(cellValue);
                    if ((CVV == (int) jsonObject.get("cvv_nbr"))
                            && (EXP_DT.equalsIgnoreCase(jsonObject.get("exp_dt").toString()))
                            && (ZIP_CODE.equalsIgnoreCase(jsonObject.get("zip_code").toString()))) {
                        if (ORDER_TOTAL > (double) jsonObject.get("avail_balance")) {
                            throw new PaymentException("Account doesn't have enough balance to process this request");
                        } else {
                                //Yet to write code
                        }
                    }
                    else {
                        throw new PaymentException("card details are not matching");
                    }
                }
            }
        } else  {
            throw new PaymentException("card number is not valid");
        }
    }

    public void insertPayment()
            throws IOException,GeneralSecurityException{

        /**inserting payment details in payment table**/

        String INSERTPAYMENTSQL="INSERT INTO PROJECTDATA.ORD_PAYMT_DTL "+
                "(CUSTOMER_ID," +
                "ORDER_ID," +
                "CARD_NUMBER," +
                "CVV," +
                "CARD_EXP_DATE," +
                "ZIP_CODE," +
                "CARD_FIRST_NAME," +
                "CARD_LAST_NAME, " +
                "CRT_DT, " +
                "CRT_TS) VALUES "+
                "('"+CUSTOMER_ID+"'," +
                "'H1'," +
                "'"+CARD_NBR+"'," +
                "'"+CVV+"'," +
                "'"+EXP_DT+"'," +
                "'"+ZIP_CODE+"'," +
                "'"+CUSTOMER_FN +"'," +
                "'"+CUSTOMER_LN+"'," +
                "CURRENT_DATE," +
                "CURRENT_TIME)";

        System.out.println("PaymentDetails:"+INSERTPAYMENTSQL);

        /**execute the query**/
        QueryResponse query = this.bq.jobs().query(ProjectID,
                new QueryRequest().setQuery(INSERTPAYMENTSQL).setUseLegacySql(false)).execute();
    }

}
