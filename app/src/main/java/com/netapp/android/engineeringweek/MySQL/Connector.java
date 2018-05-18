package com.netapp.android.engineeringweek.MySQL;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Samin on 08/05/2018.
 */

public class Connector {

    public static Object connect(String urlAddress) {
        try {
            URL url = new URL(urlAddress);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set connection params
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(15000);
            connection.setReadTimeout(15000);
            connection.setDoInput(true);

            return connection;

        } catch(MalformedURLException e) {
            e.printStackTrace();
            return "Error " + e.getMessage();
        } catch(IOException e) {
            e.printStackTrace();
            return "Error " + e.getMessage();
        }
    }
}
