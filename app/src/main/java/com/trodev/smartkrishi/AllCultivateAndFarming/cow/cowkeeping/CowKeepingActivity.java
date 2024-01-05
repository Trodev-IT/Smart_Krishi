package com.trodev.smartkrishi.AllCultivateAndFarming.cow.cowkeeping;

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
import com.trodev.smartkrishi.AllCultivateAndFarming.agricultureinformation.fruits.FruitsActivity;
import com.trodev.smartkrishi.AllCultivateAndFarming.agricultureinformation.fruits.FruitsAdapter;
import com.trodev.smartkrishi.AllCultivateAndFarming.agricultureinformation.fruits.FruitsData;
import com.trodev.smartkrishi.R;

import java.util.ArrayList;

public class CowKeepingActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ProgressBar progressBar;
    DatabaseReference reference, dbRef;
    ArrayList<CowData> listanimal;
    CowAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cow_keeping);

        getSupportActionBar().setTitle("গবাদিপশু পালন");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView= findViewById(R.id.recyclerView);
        progressBar= findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);

        reference = FirebaseDatabase.getInstance().getReference().child("Cow");

        showData();
    }

    private void showData() {

        dbRef = reference.child("গবাদিপশু পালন");
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
                        CowData data = snapshot.getValue(CowData.class);
                        listanimal.add(data);
                    }
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(new LinearLayoutManager(CowKeepingActivity.this));
                    adapter = new CowAdapter(CowKeepingActivity.this, listanimal, "গবাদিপশু পালন");
                    recyclerView.setAdapter(adapter);
                    progressBar.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                progressBar.setVisibility(View.VISIBLE);
                recyclerView.setVisibility(View.INVISIBLE);
                Toast.makeText(CowKeepingActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}