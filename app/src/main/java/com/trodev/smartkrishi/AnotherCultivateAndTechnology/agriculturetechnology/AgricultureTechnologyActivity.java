package com.trodev.smartkrishi.AnotherCultivateAndTechnology.agriculturetechnology;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.trodev.smartkrishi.AnotherCultivateAndTechnology.health.HealthActivity;
import com.trodev.smartkrishi.AnotherCultivateAndTechnology.health.HealthAdapter;
import com.trodev.smartkrishi.AnotherCultivateAndTechnology.health.HealthData;
import com.trodev.smartkrishi.R;

import java.util.ArrayList;

public class AgricultureTechnologyActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ProgressBar progressBar;
    DatabaseReference reference, dbRef;
    ArrayList<AgricultureTechnologyData> listanother;
    AgricultureTechnologyAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agriculture_technology);

        getSupportActionBar().setTitle("কৃষি উপকরণ ও প্রযুক্তি");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView= findViewById(R.id.recyclerView);
        progressBar= findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);

        reference = FirebaseDatabase.getInstance().getReference().child("AnotherCultivateAndTechnology");
        showData();
    }
    private void showData() {

        dbRef = reference.child("কৃষি উপকরণ ও প্রযুক্তি");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listanother = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    recyclerView.setVisibility(View.GONE); // change
                } else {
                    recyclerView.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.INVISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        AgricultureTechnologyData data = snapshot.getValue(AgricultureTechnologyData.class);
                        listanother.add(data);
                    }
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(new LinearLayoutManager(AgricultureTechnologyActivity.this));
                    adapter = new AgricultureTechnologyAdapter(AgricultureTechnologyActivity.this, listanother, "কৃষি উপকরণ ও প্রযুক্তি");
                    recyclerView.setAdapter(adapter);
                    progressBar.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                progressBar.setVisibility(View.VISIBLE);
                recyclerView.setVisibility(View.INVISIBLE);
                Toast.makeText(AgricultureTechnologyActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}