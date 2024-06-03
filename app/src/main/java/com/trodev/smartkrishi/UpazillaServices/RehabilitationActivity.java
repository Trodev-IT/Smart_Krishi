package com.trodev.smartkrishi.UpazillaServices;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.trodev.smartkrishi.R;

public class RehabilitationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rehabilitation);

        /*Navigation Bar Views*/
        getSupportActionBar().setTitle("কৃষি পুনর্বাসন সহায়তা");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}