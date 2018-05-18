package com.netapp.android.engineeringweek.MySQL;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ExpandableListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Samin on 08/05/2018.
 */

public class DataParser extends AsyncTask<Void, Void, Boolean> {
    Context context;
    String jsonData;
    ExpandableListView elv;

    ArrayList<String> sessions = new ArrayList<>();

    public DataParser(Context context, String jsonData, ExpandableListView elv) {
        this.context = context;
        this.jsonData = jsonData;
        this.elv = elv;
    }

    @Override
    protected Boolean doInBackground(Void... voids) {
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
    }

    private Boolean parseData() {
        try {
            JSONArray jsonArray = new JSONArray(jsonData);
            JSONObject jsonObject;

            sessions.clear();

            for(int i = 0; i < jsonArray.length(); i++) {
                jsonObject = jsonArray.getJSONObject(i);

                String name = jsonObject.getString("session_name");
                sessions.add(name);
            }

            return true;

        } catch(JSONException e) {
            e.printStackTrace();
        }

        return false;
    }
}
