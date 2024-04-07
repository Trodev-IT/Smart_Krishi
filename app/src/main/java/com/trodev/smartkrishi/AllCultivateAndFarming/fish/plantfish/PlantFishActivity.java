package com.trodev.smartkrishi.AllCultivateAndFarming.fish.plantfish;

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
import com.trodev.smartkrishi.AllCultivateAndFarming.fish.combinedfish.CombinedFishActivity;
import com.trodev.smartkrishi.AllCultivateAndFarming.fish.combinedfish.CombinedFishAdapter;
import com.trodev.smartkrishi.AllCultivateAndFarming.fish.combinedfish.CombinedFishData;
import com.trodev.smartkrishi.R;

import java.util.ArrayList;

public class PlantFishActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ProgressBar progressBar;
    DatabaseReference reference, dbRef;
    ArrayList<PlantFishData> listfishl;
    PlantFishAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_fish);

        getSupportActionBar().setTitle("পোনা, খাদ্য ও পুকুর ব্যবস্থাপনা");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView= findViewById(R.id.recyclerView);
        progressBar= findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);


        reference = FirebaseDatabase.getInstance().getReference().child("Fish");

        showData();
    }

    private void showData() {

        dbRef = reference.child("পোনা, খাদ্য ও পুকুর ব্যবস্থাপনা");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listfishl = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    recyclerView.setVisibility(View.GONE); // change
                } else {
                    recyclerView.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.INVISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        PlantFishData data = snapshot.getValue(PlantFishData.class);
                        listfishl.add(data);
                    }
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(new LinearLayoutManager(PlantFishActivity.this));
                    adapter = new PlantFishAdapter(PlantFishActivity.this, listfishl, "পোনা, খাদ্য ও পুকুর ব্যবস্থাপনা");
                    recyclerView.setAdapter(adapter);
                    progressBar.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                progressBar.setVisibility(View.VISIBLE);
                recyclerView.setVisibility(View.INVISIBLE);
                Toast.makeText(PlantFishActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}