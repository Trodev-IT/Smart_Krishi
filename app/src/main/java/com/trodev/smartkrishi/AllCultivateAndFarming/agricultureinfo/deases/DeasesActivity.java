package com.trodev.smartkrishi.AllCultivateAndFarming.agricultureinfo.deases;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.trodev.smartkrishi.R;

public class DeasesActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deases);

        getSupportActionBar().setTitle("রোগ বালাই ও প্রতিকার");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView= findViewById(R.id.recyclerView);
        progressBar= findViewById(R.id.progressBar);

        progressBar.setVisibility(View.VISIBLE);
    }
}