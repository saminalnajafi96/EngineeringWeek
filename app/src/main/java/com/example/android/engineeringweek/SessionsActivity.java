package com.example.android.engineeringweek;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class SessionsActivity extends AppCompatActivity {

    Toolbar toolbar;
    CheckBox checkBox;
    ExpandableListAdapter expandableListAdapter;
    ExpandableListView expandableListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    return true;
                case R.id.navigation_dashboard:
                    return true;
                case R.id.navigation_notifications:
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sessions);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        // Get the ListView
        expandableListView = (ExpandableListView) findViewById(R.id.sessionsExpandableListView);

        // Prepare the list data
        prepareListData();

        expandableListAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // Set the list adapter and expand lists by default
        expandableListView.setAdapter(expandableListAdapter);
        expandableListView.expandGroup(0);

        // Get checkbox values
        checkBox = (CheckBox) findViewById(R.id.checkbox);
    }

    /**
     * Prepare the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Header data
        listDataHeader.add("22nd May 2018");
        listDataHeader.add("23rd May 2018");

        // Child data
        List<String> may22 = new ArrayList<>();
        may22.add("09:00 - 10:00    ONTAP 9.4");
        may22.add("10:00 - 10:30    Data Fabric");
        may22.add("10:30 - 11:00    FlexPod");
        may22.add("11:00 - 12:00    Snapcenter update");
        may22.add("09:00 - 10:00    ONTAP 9.4");
        may22.add("10:00 - 10:30    Data Fabric");
        may22.add("10:30 - 11:00    FlexPod");
        may22.add("11:00 - 12:00    Snapcenter update");
        may22.add("13:00 - 13:30    Cloud Data Services");
        may22.add("13:30 - 14:00    SolidFire");
        may22.add("14:00 - 15:00    HCI");
        may22.add("15:00 - 15:30    NFLEX");
        may22.add("15:30 - 16:00    NFSaaS");
        may22.add("16:00 - 17:00    Modernize your storage");
        may22.add("17:00 - 17:30    Machine Learning & AI");

        List<String> may23 = new ArrayList<>();
        may23.add("09:00 - 10:00    ONTAP 9.4");
        may23.add("10:00 - 10:30    Data Fabric");
        may23.add("10:30 - 11:00    FlexPod");
        may23.add("09:00 - 10:00    ONTAP 9.4");
        may23.add("10:00 - 10:30    Data Fabric");
        may23.add("10:30 - 11:00    FlexPod");
        may23.add("11:00 - 12:00    Snapcenter update");
        may23.add("13:00 - 13:30    Cloud Data Services");
        may23.add("13:30 - 14:00    SolidFire");
        may23.add("14:00 - 15:00    HCI");
        may23.add("15:00 - 15:30    NFLEX");
        may23.add("15:30 - 16:00    NFSaaS");
        may23.add("16:00 - 17:00    Modernize your storage");
        may23.add("17:00 - 17:30    Machine Learning & AI");

        // Header, Child data
        listDataChild.put(listDataHeader.get(0), may22);
        listDataChild.put(listDataHeader.get(1), may23);
    }
}
