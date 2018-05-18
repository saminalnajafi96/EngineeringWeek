package com.netapp.android.engineeringweek;

import android.content.Context;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by Samin on 11/05/2018.
 */

public class CSV {
    String fileName;

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void getUserCSV(int userType, int day) {
        if(userType == 0) {
            if(day == 0) {
                setFileName("events_22");
            } else if(day == 1) {
                setFileName("events_23");
            } else {
                setFileName("events_24");
            }
        } else if(userType == 1) {
            if(day == 0) {
                setFileName("events_22_johnsmith");
            } else if(day == 1) {

            } else {

            }
        }
    }

    public void fillAgenda(List<String> arrl, int userType, Context context) throws IOException {
        CSVReader reader = new CSVReader(new InputStreamReader(context.getAssets().open(getFileName() + ".csv")));

        String[] record;

        while((record = reader.readNext()) != null) {
            if(record[4].equals(Integer.toString(userType))) {
                arrl.add(record[2]);
            }
        }
        reader.close();
    }

    public String[] getMoreInfo(int userType, int childPosition, Context context) throws IOException {
        CSVReader reader = new CSVReader(new InputStreamReader(context.getAssets().open(getFileName() + ".csv")));
        String[] record;
        String[] info = new String[2];
        while((record = reader.readNext()) != null) {
            if(record[0].equals(Integer.toString(childPosition))) {
                info[0] = record[1];
                info[1] = record[3];
            }
        }
        reader.close();

        return info;
    }
}
