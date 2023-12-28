package com.trodev.smartkrishi.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.trodev.smartkrishi.R;

public class AboutUsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        getSupportActionBar().setTitle("About Apps");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}