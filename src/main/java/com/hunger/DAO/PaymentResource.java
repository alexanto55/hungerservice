package com.hunger.DAO;

import com.google.api.services.bigquery.Bigquery;
import com.google.api.services.bigquery.model.QueryRequest;
import com.google.api.services.bigquery.model.QueryResponse;
import com.hunger.bean.OrderRequest;
import com.hunger.bean.PaymentInfo;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class PaymentResource {

    public void getPaymentDetails(OrderRequest orderRequest) throws IOException,GeneralSecurityException{
        PaymentInfo paymentInfo = new PaymentInfo();
        PaymentResource paymentDAO   = new PaymentResource();

        String cardNumber = orderRequest.getOrderDetails().getPaymentDetails().getCardNumber();
        String cardCvv= orderRequest.getOrderDetails().getPaymentDetails().getCardCVVNumber();
        String cardExpDate=orderRequest.getOrderDetails().getPaymentDetails().getCardExpDate();
        String zipCode=orderRequest.getOrderDetails().getPaymentDetails().getZipcode();
        String cardHolderFirstName=orderRequest.getOrderDetails().getPaymentDetails().getCardHolderFirstName();
        String cardHolderLastName=orderRequest.getOrderDetails().getPaymentDetails().getCardHolderLastName();
        String customerID=orderRequest.getOrderDetails().getCustomerDetails().getCustomerId();
        System.out.println("CARDNUMBER:" +cardNumber);
      insertPayment(customerID,cardNumber,cardCvv,cardExpDate,zipCode,cardHolderFirstName,
                cardHolderLastName);
    }


    private static String ProjectID = "hunger-180002";

    public void insertPayment(String customerID,String cardNumber,String cVV,String cardExpDate,
                              String zipCode,String cardHolderFirstName,String cardHolderLastName)
            throws IOException,GeneralSecurityException{

        /**inserting payment details in payment table**/

        String paymentDetails="insert into ProjectData.ord_paymt_dtl "+
            "(customer_id,card_number,cvv,card_exp_date,zip_code,card_first_name,card_last_name) values "+
       "('"+customerID+"','"+cardNumber+"','"+cVV+"','"+cardExpDate+"','"+zipCode+"'," +
                "'"+cardHolderFirstName+"','"+cardHolderLastName+"')";

        System.out.println("PaymentDetails:"+paymentDetails);
        BigqueryTable bigqueryTable = new BigqueryTable();
        Bigquery bq = bigqueryTable.getBigquryTable();

        /**execute the query**/
        QueryResponse query = bq.jobs().query(ProjectID,
                new QueryRequest().setQuery(paymentDetails).setUseLegacySql(false)).execute();

        
    }

}
