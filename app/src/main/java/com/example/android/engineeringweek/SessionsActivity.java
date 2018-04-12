package com.example.android.engineeringweek;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class SessionsActivity extends AppCompatActivity {

    private ListView sessionsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sessions);

        sessionsList = (ListView) findViewById(R.id.sessionsListView);
        final ArrayList<String> sessionNames = new ArrayList<>();
        sessionNames.add("ONTAP Update");
        sessionNames.add("Data Fabric");
        sessionNames.add("NVMe-oF");

        String[] listItems = new String[sessionNames.size()];
        for(int i = 0; i < sessionNames.size(); i++) {
            String s = sessionNames.get(i);
            listItems[i] = s;
        }

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems);
        sessionsList.setAdapter(adapter);
    }
}
