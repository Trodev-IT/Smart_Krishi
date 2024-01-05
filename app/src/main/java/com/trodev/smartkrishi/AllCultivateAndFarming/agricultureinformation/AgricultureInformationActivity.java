package com.trodev.smartkrishi.AllCultivateAndFarming.agricultureinformation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.trodev.smartkrishi.AllCultivateAndFarming.agricultureinformation.combined.CombinedCultivationActivity;
import com.trodev.smartkrishi.AllCultivateAndFarming.agricultureinformation.disease.DiseaseActivity;
import com.trodev.smartkrishi.AllCultivateAndFarming.agricultureinformation.fertilizer.FertilizerActivity;
import com.trodev.smartkrishi.AllCultivateAndFarming.agricultureinformation.flowers.FlowersActivity;
import com.trodev.smartkrishi.AllCultivateAndFarming.agricultureinformation.fruits.FruitsActivity;
import com.trodev.smartkrishi.AllCultivateAndFarming.agricultureinformation.likely.LikelyActivity;
import com.trodev.smartkrishi.AllCultivateAndFarming.agricultureinformation.medicinesplant.MedicinesPlantActivity;
import com.trodev.smartkrishi.AllCultivateAndFarming.agricultureinformation.potato.PotatoActivity;
import com.trodev.smartkrishi.AllCultivateAndFarming.agricultureinformation.rice.RiceActivity;
import com.trodev.smartkrishi.AllCultivateAndFarming.agricultureinformation.roof.RoofActivity;
import com.trodev.smartkrishi.AllCultivateAndFarming.agricultureinformation.vegitable.VegitableActivity;
import com.trodev.smartkrishi.R;

public class AgricultureInformationActivity extends AppCompatActivity {

    CardView fruits, potato, rice, roof, vegitable, deases, medicinesplant, flower, combined, likely, fertilizer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agricultureinfo);

        getSupportActionBar().setTitle("কৃষি তথ্য");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        /*finding all items*/

        fruits= findViewById(R.id.fruits);
        potato= findViewById(R.id.potato);
        rice= findViewById(R.id.rice);
        roof= findViewById(R.id.roof);
        vegitable= findViewById(R.id.vegitable);
        deases= findViewById(R.id.deases);
        medicinesplant= findViewById(R.id.medicinesplant);
        flower= findViewById(R.id.flower);
        combined= findViewById(R.id.combined);
        likely= findViewById(R.id.likely);
        fertilizer= findViewById(R.id.fertilizer);

        /*set on click listener*/
        fruits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), FruitsActivity.class));
            }
        });
        potato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), PotatoActivity.class));
            }
        });
        rice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), RiceActivity.class));
            }
        });
        roof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), RoofActivity.class));
            }
        });
        vegitable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), VegitableActivity.class));
            }
        });
        deases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), DiseaseActivity.class));
            }
        });
        medicinesplant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MedicinesPlantActivity.class));
            }
        });
        flower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), FlowersActivity.class));
            }
        });
        combined.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), CombinedCultivationActivity.class));
            }
        });
        likely.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), LikelyActivity.class));
            }
        });
        fertilizer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), FertilizerActivity.class));
            }
        });

        return;
    }
}