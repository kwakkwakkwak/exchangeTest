package com.example.demo.currencylayer;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LiveResponse {

    public static final String ACCESS_KEY = "50d6fe2ee2ac3fce4f3c5c9449adf218";
    public static final String BASE_URL = "http://api.currencylayer.com/";
    public static final String ENDPOINT = "live";

    public static CloseableHttpClient httpClient =  HttpClients.createDefault();;


    public static Map sendLiveRequestOne(String quote){

        // The following line initializes the HttpGet Object with the URL in order to send a request
        HttpGet get = new HttpGet(BASE_URL + ENDPOINT + "?access_key=" + ACCESS_KEY);
        Map result = new HashMap();

        try {
            CloseableHttpResponse response =  httpClient.execute(get);
            HttpEntity entity = response.getEntity();

            JSONObject exchangeRates = new JSONObject(EntityUtils.toString(entity));

            String exchangeRate = String.format("%,.2f",exchangeRates.getJSONObject("quotes").getDouble("USD"+quote));
            result.put("exchangeRate",exchangeRate);

            response.close();

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }finally {
            return result;
        }
    }
}
