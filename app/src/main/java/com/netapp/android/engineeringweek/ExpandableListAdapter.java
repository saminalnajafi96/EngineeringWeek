package com.netapp.android.engineeringweek;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.opencsv.CSVReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Samin on 13/04/2018.
 */

public class ExpandableListAdapter extends BaseExpandableListAdapter {
    private Context _context;
    private List<String> _listDataHeader;
    private HashMap<String, List<String>> _listDataChild;

    public ExpandableListAdapter(Context context, List<String> listDataHeader, HashMap<String, List<String>> listDataChild) {
        this._context = context;
        this._listDataHeader = listDataHeader;
        this._listDataChild = listDataChild;
    }

    @Override
    public int getGroupCount() {
        return this._listDataHeader.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this._listDataHeader.get(groupPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition);
        if(convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this._context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_group, null);
        }

        TextView listHeader = convertView.findViewById(R.id.listHeader);
        listHeader.setTypeface(null, Typeface.BOLD);
        listHeader.setText(headerTitle);

        return convertView;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, final ViewGroup parent) {
        final String childText = (String) getChild(groupPosition, childPosition);

        if(convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this._context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_item, null);
        }

        // TextView which will hold the text of the child item
        TextView textListChild = convertView.findViewById(R.id.listItem);
        ImageButton moreInfoButton = convertView.findViewById(R.id.moreButton);

        moreInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    CSV csv = SessionsActivity.csv;
                    int userType = SessionsActivity.userType;
                    csv.getUserCSV(userType, groupPosition);

                    String[] info = csv.getMoreInfo(userType, childPosition, parent.getContext());

                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(parent.getContext());

                    if(info[1].equals("none")) {
                        alertDialogBuilder.setMessage("Time: " + info[0]);
                    } else {
                        alertDialogBuilder.setMessage("Time: " + info[0] + "\n\n" + "Speaker(s): " + info[1]);
                    }

                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        // Set the text of the child item
        textListChild.setText(childText);

        return convertView;
    }

    public boolean sessionExists(String session, ArrayList<String> sessionsList) {
        for(int i = 0; i < sessionsList.size(); i++) {
            if(sessionsList.get(i) == session) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition)).size();
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

}
