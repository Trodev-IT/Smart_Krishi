package com.trodev.smartkrishi.AllCultivateAndFarming.hen.duck;

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
import com.trodev.smartkrishi.AllCultivateAndFarming.hen.hen.HenActivity;
import com.trodev.smartkrishi.AllCultivateAndFarming.hen.hen.HenAdapter;
import com.trodev.smartkrishi.AllCultivateAndFarming.hen.hen.HenData;
import com.trodev.smartkrishi.R;

import java.util.ArrayList;

public class DuckActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ProgressBar progressBar;
    DatabaseReference reference, dbRef;
    ArrayList<DuckData> listhen;
    DuckAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duck);

        getSupportActionBar().setTitle("হাঁস পালন ও পরিচর্যা");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView= findViewById(R.id.recyclerView);
        progressBar= findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);

        reference = FirebaseDatabase.getInstance().getReference().child("Hen");

        showData();
    }
    private void showData() {

        dbRef = reference.child("হাঁস পালন ও পরিচর্যা");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listhen = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    recyclerView.setVisibility(View.GONE); // change
                } else {
                    recyclerView.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.INVISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                       DuckData data = snapshot.getValue(DuckData.class);
                        listhen.add(data);
                    }
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(new LinearLayoutManager(DuckActivity.this));
                    adapter = new DuckAdapter(DuckActivity.this, listhen, "হাঁস পালন ও পরিচর্যা");
                    recyclerView.setAdapter(adapter);
                    progressBar.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                progressBar.setVisibility(View.VISIBLE);
                recyclerView.setVisibility(View.INVISIBLE);
                Toast.makeText(DuckActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}