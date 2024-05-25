package com.trodev.smartkrishi.AllCultivateAndFarming.agricultureinformation.fertilizer;

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
import com.trodev.smartkrishi.AllCultivateAndFarming.agricultureinformation.rice.RiceActivity;
import com.trodev.smartkrishi.AllCultivateAndFarming.agricultureinformation.rice.RiceAdapter;
import com.trodev.smartkrishi.AllCultivateAndFarming.agricultureinformation.rice.RiceData;
import com.trodev.smartkrishi.R;

import java.util.ArrayList;

public class FertilizerActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ProgressBar progressBar;
    DatabaseReference reference, dbRef;
    ArrayList<FertilizerData> listagricultureinformation;
    FertilizerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fertilizer);

        getSupportActionBar().setTitle("সার বিষয়ক তথ্য");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView= findViewById(R.id.recyclerView);
        progressBar= findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);

        reference = FirebaseDatabase.getInstance().getReference().child("AgricultureInformation");
        showData();
    }

    private void showData() {

        dbRef = reference.child("সার বিষয়ক তথ্য");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listagricultureinformation = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    recyclerView.setVisibility(View.GONE); // change
                } else {
                    recyclerView.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.INVISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        FertilizerData data = snapshot.getValue(FertilizerData.class);
                        listagricultureinformation.add(data);
                    }
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(new LinearLayoutManager(FertilizerActivity.this));
                    adapter = new FertilizerAdapter(FertilizerActivity.this, listagricultureinformation, "সার বিষয়ক তথ্য");
                    recyclerView.setAdapter(adapter);
                    progressBar.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                progressBar.setVisibility(View.VISIBLE);
                recyclerView.setVisibility(View.INVISIBLE);
                Toast.makeText(FertilizerActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}