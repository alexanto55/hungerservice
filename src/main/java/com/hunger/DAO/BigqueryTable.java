package com.hunger.DAO;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.util.Utils;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.bigquery.Bigquery;
import com.google.api.services.bigquery.BigqueryScopes;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.Collections;

public class BigqueryTable {

    private static String ProjectID = "hunger-180002";
    private static String credentialURL = "src/main/hunger-04e932189595.json";

    public Bigquery getBigquryTable () throws IOException, GeneralSecurityException{

        return new Bigquery
                .Builder(new NetHttpTransport(),
                             JacksonFactory.getDefaultInstance(),
                             getGoogleCredentials(Utils.getDefaultTransport(), Utils.getDefaultJsonFactory()))
                .setApplicationName(ProjectID)
                .build();
    }

    public static GoogleCredential getGoogleCredentials(HttpTransport httpTransport, JsonFactory jsonFactory) throws IOException, GeneralSecurityException{

        InputStream resourceStream = new FileInputStream(credentialURL);
        GoogleCredential credential = GoogleCredential.fromStream(resourceStream);

        if (credential.createScopedRequired()) {
            credential = credential.createScoped(Collections.singleton(BigqueryScopes.BIGQUERY));
        }
    return credential;
    }

}
