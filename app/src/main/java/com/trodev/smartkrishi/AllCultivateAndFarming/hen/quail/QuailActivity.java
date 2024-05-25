package com.trodev.smartkrishi.AllCultivateAndFarming.hen.quail;

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

public class QuailActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ProgressBar progressBar;
    DatabaseReference reference, dbRef;
    ArrayList<QuailData> listhen;
    QuailAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quail);

        getSupportActionBar().setTitle("কোয়েল পাখি পালন ও চিকিৎসা");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView= findViewById(R.id.recyclerView);
        progressBar= findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);

        reference = FirebaseDatabase.getInstance().getReference().child("Hen");

        showData();
    }
    private void showData() {

        dbRef = reference.child("কোয়েল পাখি পালন ও চিকিৎসা");
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
                        QuailData data = snapshot.getValue(QuailData.class);
                        listhen.add(data);
                    }
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(new LinearLayoutManager(QuailActivity.this));
                    adapter = new QuailAdapter(QuailActivity.this, listhen, "কোয়েল পাখি পালন ও চিকিৎসা");
                    recyclerView.setAdapter(adapter);
                    progressBar.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                progressBar.setVisibility(View.VISIBLE);
                recyclerView.setVisibility(View.INVISIBLE);
                Toast.makeText(QuailActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}