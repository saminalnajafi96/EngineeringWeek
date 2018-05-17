package com.netapp.android.engineeringweek;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LoginActivity extends AppCompatActivity {

    public static int str;
    private static final String TAG = "LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



    }

    @Override
    protected void onStart()
    {
        super.onStart();
        fileCheck();

    }

    public void fileCheck() {
        Log.i(TAG, "IF RUNNING");
        File directory = getFilesDir();
        File userfile = new File(directory+"/user.csv");
        if (userfile.exists()) {
            Intent intent = new Intent(this, HomeActivity.class);
            Log.i(TAG, "File Exists");
            startActivity(intent);
        }
    }


    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.btnCustomer:
                if (checked)
                    str = 0;
                    break;
            case R.id.btnPartner:
                if (checked)
                    str = 1;
                    break;
        }
    }

    public void submitUser(View v){
        Log.i(TAG, "Submit Button Clicked");
        try {

            File directory = getFilesDir();

            File file = new File(directory+"/user.csv");

            FileWriter fileWriter = new FileWriter(file);

            CSVWriter csvWriter = new CSVWriter(fileWriter);

            csvWriter.writeNext(new String[]{Integer.toString(str)});

            csvWriter.close();

            System.out.println(file.length());

            CSVReader csvReader = new CSVReader(new FileReader(file));

            String[] fileOutput;

            Intent myIntent = new Intent(LoginActivity.this, HomeActivity.class);
            LoginActivity.this.startActivity(myIntent);

            while ((fileOutput = csvReader.readNext()) != null) {
                System.out.println(fileOutput[0]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
