package com.trodev.smartkrishi.AllCultivateAndFarming.cow.cowfeeding;

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
import com.trodev.smartkrishi.AllCultivateAndFarming.cow.cowkeeping.CowAdapter;
import com.trodev.smartkrishi.AllCultivateAndFarming.cow.cowkeeping.CowData;
import com.trodev.smartkrishi.AllCultivateAndFarming.cow.cowkeeping.CowKeepingActivity;
import com.trodev.smartkrishi.R;

import java.util.ArrayList;

public class CowFeedingActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ProgressBar progressBar;
    DatabaseReference reference, dbRef;
    ArrayList<CowFeedingData> listanimal;
    CowFeedingAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cow_feeding);

        getSupportActionBar().setTitle("গো-খাদ্য ব্যবস্থাপনা");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView= findViewById(R.id.recyclerView);
        progressBar= findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);

        reference = FirebaseDatabase.getInstance().getReference().child("Cow");

        showData();
    }

    private void showData() {

        dbRef = reference.child("গো-খাদ্য ব্যবস্থাপনা");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listanimal = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    recyclerView.setVisibility(View.GONE); // change
                } else {
                    recyclerView.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.INVISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        CowFeedingData data = snapshot.getValue(CowFeedingData.class);
                        listanimal.add(data);
                    }
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(new LinearLayoutManager(CowFeedingActivity.this));
                    adapter = new CowFeedingAdapter(CowFeedingActivity.this, listanimal, "গো-খাদ্য ব্যবস্থাপনা");
                    recyclerView.setAdapter(adapter);
                    progressBar.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                progressBar.setVisibility(View.VISIBLE);
                recyclerView.setVisibility(View.INVISIBLE);
                Toast.makeText(CowFeedingActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}