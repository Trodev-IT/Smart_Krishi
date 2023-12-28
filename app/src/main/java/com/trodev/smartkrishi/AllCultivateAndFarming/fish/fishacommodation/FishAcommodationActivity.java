package com.trodev.smartkrishi.AllCultivateAndFarming.fish.fishacommodation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.trodev.smartkrishi.R;

public class FishAcommodationActivity extends AppCompatActivity {

    RecyclerView recyclerViewl;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fish_acommodation);

        getSupportActionBar().setTitle("মাছ চাষের র্পুনাঙ্গ ব্যবস্থাপত্র");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerViewl= findViewById(R.id.recyclerView);
        progressBar= findViewById(R.id.progressBar);

        progressBar.setVisibility(View.VISIBLE);
    }
}