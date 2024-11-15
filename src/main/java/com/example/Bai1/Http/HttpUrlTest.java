package com.example.Bai1.Http;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUrlTest {
    private static HttpURLConnection connection;
    public static String connect(URL url){
        try {
            connection =(HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(10000);
            connection.setReadTimeout(10000);
            int responseCode = connection.getResponseCode();
            System.out.println(responseCode);
            if(responseCode == HttpURLConnection.HTTP_OK){
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = bufferedReader.readLine()) != null){
                    response.append(inputLine).append('\n');
                }
                bufferedReader.close();
                FileWriter fileWriter = new FileWriter("httpUrlCls.txt");
                fileWriter.write(response.toString());
                return response.toString();
            }else {
                System.out.println("Get not work");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
