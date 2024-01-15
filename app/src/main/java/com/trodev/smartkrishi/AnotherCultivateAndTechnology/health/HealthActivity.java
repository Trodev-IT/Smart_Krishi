package com.trodev.smartkrishi.AnotherCultivateAndTechnology.health;

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
import com.trodev.smartkrishi.AllCultivateAndFarming.fish.nativefish.NativeFishActivity;
import com.trodev.smartkrishi.AllCultivateAndFarming.fish.nativefish.NativeFishAdapter;
import com.trodev.smartkrishi.AllCultivateAndFarming.fish.nativefish.NativeFishData;
import com.trodev.smartkrishi.R;

import java.util.ArrayList;

public class HealthActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ProgressBar progressBar;
    DatabaseReference reference, dbRef;
    ArrayList<HealthData> listanother;
    HealthAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health);

        getSupportActionBar().setTitle("স্বাস্থ্য বটিকা");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView= findViewById(R.id.recyclerView);
        progressBar= findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);

        reference = FirebaseDatabase.getInstance().getReference().child("AnotherCultivateAndTechnology");
        showData();
    }
    private void showData() {

        dbRef = reference.child("স্বাস্থ্য বটিকা");
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
                        HealthData data = snapshot.getValue(HealthData.class);
                        listanother.add(data);
                    }
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(new LinearLayoutManager(HealthActivity.this));
                    adapter = new HealthAdapter(HealthActivity.this, listanother, "স্বাস্থ্য বটিকা");
                    recyclerView.setAdapter(adapter);
                    progressBar.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                progressBar.setVisibility(View.VISIBLE);
                recyclerView.setVisibility(View.INVISIBLE);
                Toast.makeText(HealthActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}