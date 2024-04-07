package com.trodev.smartkrishi.AllCultivateAndFarming.fish.fishdisease;

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

public class FishDiseaseActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ProgressBar progressBar;
    DatabaseReference reference, dbRef;
    ArrayList<FishDiseaseData> listfishl;
    FishDiseaseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fish_disease);

        getSupportActionBar().setTitle("মাছের রোগব্যাধি ও প্রতিকার");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView= findViewById(R.id.recyclerView);
        progressBar= findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);

        reference = FirebaseDatabase.getInstance().getReference().child("Fish");

        showData();
    }

    private void showData() {

        dbRef = reference.child("মাছের রোগব্যাধি ও প্রতিকার");
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
                        FishDiseaseData data = snapshot.getValue(FishDiseaseData.class);
                        listfishl.add(data);
                    }
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(new LinearLayoutManager(FishDiseaseActivity.this));
                    adapter = new FishDiseaseAdapter(FishDiseaseActivity.this, listfishl, "মাছের রোগব্যাধি ও প্রতিকার");
                    recyclerView.setAdapter(adapter);
                    progressBar.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                progressBar.setVisibility(View.VISIBLE);
                recyclerView.setVisibility(View.INVISIBLE);
                Toast.makeText(FishDiseaseActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}