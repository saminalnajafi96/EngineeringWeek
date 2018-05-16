package com.netapp.android.engineeringweek;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void openAgenda(View v){
    //    startActivity(new Intent(HomeActivity.this, agenda.class));
    }

    public void openTwitter(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/netappuk"));
        startActivity(intent);
    }

    public void openFacebook(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/NetApp-UK-76548322331/"));
        startActivity(intent);
    }

    public void openLinkedIn(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/company/netapp-uk"));
        startActivity(intent);
    }
}
