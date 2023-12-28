package com.trodev.smartkrishi.AllCultivateAndFarming.hen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.trodev.smartkrishi.R;

public class HenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hen);

        getSupportActionBar().setTitle("হাস, মুরগি পালন");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}