package com.trodev.smartkrishi.AllCultivateAndFarming.hen.quail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.trodev.smartkrishi.R;

public class QuailActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quail);

        getSupportActionBar().setTitle("কোয়েল পাখি পালন ও চিকিৎসা");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView= findViewById(R.id.recyclerView);
        progressBar= findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);
    }
}