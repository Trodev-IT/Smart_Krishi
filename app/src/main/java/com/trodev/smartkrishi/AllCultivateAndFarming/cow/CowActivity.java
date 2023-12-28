package com.trodev.smartkrishi.AllCultivateAndFarming.cow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.trodev.smartkrishi.AllCultivateAndFarming.cow.cowacommodation.CowAcommodationActivity;
import com.trodev.smartkrishi.AllCultivateAndFarming.cow.cowbreeding.CowBreedingActivity;
import com.trodev.smartkrishi.AllCultivateAndFarming.cow.cowdisease.CowDiseaseActivity;
import com.trodev.smartkrishi.AllCultivateAndFarming.cow.cowfeeding.CowFeedingActivity;
import com.trodev.smartkrishi.AllCultivateAndFarming.cow.cowkeeping.CowKeepingActivity;
import com.trodev.smartkrishi.R;

public class CowActivity extends AppCompatActivity {

    CardView cowkeeping, cowacommodation, cowbreeding, cowfeeding, cowdisease;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cow);

        getSupportActionBar().setTitle("গবাদি পশুপালন");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        /*finding all items*/

        cowkeeping= findViewById(R.id.cowkeeping);
        cowacommodation= findViewById(R.id.cowacommodation);
        cowbreeding= findViewById(R.id.cowbreeding);
        cowfeeding= findViewById(R.id.cowfeeding);
        cowdisease= findViewById(R.id.cowdisease);

        /*set on click listener*/
        cowkeeping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), CowKeepingActivity.class));
            }
        });
        cowacommodation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), CowAcommodationActivity.class));
            }
        });
        cowbreeding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), CowBreedingActivity.class));
            }
        });
        cowfeeding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), CowFeedingActivity.class));
            }
        });
        cowdisease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), CowDiseaseActivity.class));
            }
        });

        return;
    }
}