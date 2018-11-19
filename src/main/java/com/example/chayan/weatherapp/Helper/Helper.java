package com.example.chayan.weatherapp.Helper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import java.net.URISyntaxException;
import java.net.URI;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class Helper {
    static String stream = null;

    public Helper() {

    }

    public String getHTTPData(String urlString) {
        try {
            URL url = new URL(urlString);

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            if(httpURLConnection.getResponseCode()==200){
                BufferedReader r=new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                StringBuilder sb=new StringBuilder();
                String line;
                while ((line=r.readLine())!=null)
                    sb.append(line);
                stream=sb.toString();
                httpURLConnection.disconnect();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stream;
    }

}
