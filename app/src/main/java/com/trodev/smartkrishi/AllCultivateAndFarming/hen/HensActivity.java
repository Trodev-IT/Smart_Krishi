package com.trodev.smartkrishi.AllCultivateAndFarming.hen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.trodev.smartkrishi.AllCultivateAndFarming.hen.bee.BeeActivity;
import com.trodev.smartkrishi.AllCultivateAndFarming.hen.duck.DuckActivity;
import com.trodev.smartkrishi.AllCultivateAndFarming.hen.hen.HenActivity;
import com.trodev.smartkrishi.AllCultivateAndFarming.hen.ostrich.OstrichActivity;
import com.trodev.smartkrishi.AllCultivateAndFarming.hen.pecock.PecockActivity;
import com.trodev.smartkrishi.AllCultivateAndFarming.hen.pheasant.PheasantActivity;
import com.trodev.smartkrishi.AllCultivateAndFarming.hen.pigeon.PigeonActivity;
import com.trodev.smartkrishi.AllCultivateAndFarming.hen.quail.QuailActivity;
import com.trodev.smartkrishi.R;

public class HensActivity extends AppCompatActivity {

    CardView hen, duck, bee, pecock, ostrich, pheasant, quail, pigeon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hens);

        getSupportActionBar().setTitle("হাস, মুরগি ও অন্যান্য পাখি পালন এবং পদ্ধতি");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        hen= findViewById(R.id.hen);
        duck= findViewById(R.id.duck);
        bee= findViewById(R.id.bee);
        pecock= findViewById(R.id.pecock);
        ostrich= findViewById(R.id.ostrich);
        pheasant= findViewById(R.id.pheasant);
        quail= findViewById(R.id.quail);
        pigeon= findViewById(R.id.pigeon);

        hen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), HenActivity.class ));
            }
        });
        duck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), DuckActivity.class ));
            }
        });
        bee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), BeeActivity.class ));
            }
        });
        pecock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), PecockActivity.class ));
            }
        });
        ostrich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), OstrichActivity.class ));
            }
        });
        pheasant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), PheasantActivity.class ));
            }
        });
        quail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), QuailActivity.class ));
            }
        });
        pigeon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), PigeonActivity.class ));
            }
        });
    }
}