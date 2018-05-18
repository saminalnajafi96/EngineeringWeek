package com.netapp.android.engineeringweek.MySQL;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/**
 * Created by Samin on 08/05/2018.
 */

public class Downloader extends AsyncTask<Void, Void, String> {
    Context context;
    String urlAddress;
    ExpandableListView elv;


    ProgressDialog progressDialog;

    public Downloader(Context context, String urlAddress, ExpandableListView elv) {
        this.context = context;
        this.urlAddress = urlAddress;
        this.elv = elv;
    }

    @Override
    protected String doInBackground(Void... voids) {
        return this.downloadData();
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String jsonData) {
        super.onPostExecute(jsonData);

        if(jsonData.startsWith("Error")) {
            Toast.makeText(context, "Unsuccessful: " + jsonData, Toast.LENGTH_SHORT).show();
        } else {

        }
    }

    private String downloadData() {
        Object connection = Connector.connect(urlAddress);

        if(connection.toString().startsWith("Error")) {
            return connection.toString();
        }

        try {
            HttpURLConnection con = (HttpURLConnection) connection;

            InputStream inputStream = new BufferedInputStream(con.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            StringBuffer jsonData = new StringBuffer();

            while((line = bufferedReader.readLine()) != null) {
                jsonData.append(line + "\n");
            }

            bufferedReader.close();
            inputStream.close();

            return jsonData.toString();
        } catch(IOException e) {
            e.printStackTrace();
            return "Error " + e.getMessage();
        }
    }
}
