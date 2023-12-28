package com.trodev.smartkrishi.AllCultivateAndFarming.fish;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.trodev.smartkrishi.AllCultivateAndFarming.fish.combinedfish.CombinedFishActivity;
import com.trodev.smartkrishi.AllCultivateAndFarming.fish.fishacommodation.FishAcommodationActivity;
import com.trodev.smartkrishi.AllCultivateAndFarming.fish.fishbreeding.FishBreedingActivity;
import com.trodev.smartkrishi.AllCultivateAndFarming.fish.fishdisease.FishDiseaseActivity;
import com.trodev.smartkrishi.AllCultivateAndFarming.fish.nativefish.NativeFishActivity;
import com.trodev.smartkrishi.AllCultivateAndFarming.fish.plantfish.PlantFishActivity;
import com.trodev.smartkrishi.AllCultivateAndFarming.fish.prawn.PrawnActivity;
import com.trodev.smartkrishi.R;

public class FishActivity extends AppCompatActivity {

    CardView nativefish, combinedfish, plantfish, prawn, fishacommodation, fishdisease, fishbreeding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fish);

        getSupportActionBar().setTitle("মাছ চাষ");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        /*finding all items*/

        nativefish= findViewById(R.id.nativefish);
        combinedfish= findViewById(R.id.combinedfish);
        plantfish= findViewById(R.id.plantfish);
        prawn= findViewById(R.id.prawn);
        fishacommodation= findViewById(R.id.fishacommodation);
        fishdisease= findViewById(R.id.fishdisease);
        fishbreeding= findViewById(R.id.fishbreeding);

        /*set on click listener*/
        nativefish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), NativeFishActivity.class));
            }
        });
        combinedfish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), CombinedFishActivity.class));
            }
        });
        plantfish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), PlantFishActivity.class));
            }
        });
        prawn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), PrawnActivity.class));
            }
        });
        fishacommodation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), FishAcommodationActivity.class));
            }
        });
        fishdisease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), FishDiseaseActivity.class));
            }
        });
        fishbreeding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), FishBreedingActivity.class));
            }
        });


    }
}