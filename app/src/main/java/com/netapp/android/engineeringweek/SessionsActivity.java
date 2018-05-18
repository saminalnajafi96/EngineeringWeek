package com.netapp.android.engineeringweek;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SessionsActivity extends AppCompatActivity {

    final public static int userType = 0;
    final public static CSV csv = new CSV();

    ExpandableListAdapter expandableListAdapter;
    ExpandableListView expandableListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sessions);

        // Get the ListView
        expandableListView = findViewById(R.id.sessionsExpandableListView);

        // Prepare the list data
        try {
            prepareListData();
        } catch(IOException e) {
            e.printStackTrace();
        }

        expandableListAdapter = new ExpandableListAdapter(getApplicationContext(), listDataHeader, listDataChild);

        // Set the list adapter and expand lists by default
        expandableListView.setAdapter(expandableListAdapter);
        expandableListView.expandGroup(0);
    }

    /**
     * Prepare the list data
     */
    private void prepareListData() throws IOException {
        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<>();

        // Header data
        listDataHeader.add("22nd May 2018");
        listDataHeader.add("23rd May 2018");
        listDataHeader.add("24th May 2018");

        List<String> may22 = new ArrayList<>();
        csv.getUserCSV(userType, 0);
        csv.fillAgenda(may22, userType, getApplicationContext());
        CSVWriter writer = new CSVWriter(new FileWriter(String.valueOf(getApplicationContext().getAssets().open("test.csv"))));

        List<String> may23 = new ArrayList<>();
        csv.getUserCSV(userType, 1);
        csv.fillAgenda(may23, userType, getApplicationContext());

        List<String> may24 = new ArrayList<>();
        csv.getUserCSV(userType, 2);
        csv.fillAgenda(may24, userType, getApplicationContext());

        // Header, Child data
        listDataChild.put(listDataHeader.get(0), may22);
        listDataChild.put(listDataHeader.get(1), may23);
        listDataChild.put(listDataHeader.get(2), may24);
    }
}