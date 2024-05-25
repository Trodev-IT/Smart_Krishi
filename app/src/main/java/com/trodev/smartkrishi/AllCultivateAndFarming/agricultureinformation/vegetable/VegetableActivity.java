package com.trodev.smartkrishi.AllCultivateAndFarming.agricultureinformation.vegetable;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
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

public class VegetableActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ProgressBar progressBar;
    DatabaseReference reference, dbRef;
    ArrayList<VegetableData> listagricultureinformation;
    VegetableAdapter adapter;
    SearchView search_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vegitable);

        getSupportActionBar().setTitle("শাক-সবজি চাষ");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.recyclerView);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);

        /*search view implement*/
        search_view = findViewById(R.id.search_view);
        search_view.clearFocus();
        search_view.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });

        reference = FirebaseDatabase.getInstance().getReference().child("AgricultureInformation");
        showData();
    }

    public void filterList(String text) {

        ArrayList<VegetableData> filteredList = new ArrayList<>();
        for (VegetableData envatoModels : listagricultureinformation) {
            if (envatoModels.getName().toLowerCase().contains(text.toLowerCase()) || envatoModels.getName().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(envatoModels);
                recyclerView.setVisibility(View.VISIBLE);
            }
        }

        if (filteredList.isEmpty()) {
            Toast.makeText(getApplicationContext(), "No data found", Toast.LENGTH_SHORT).show();
            recyclerView.setVisibility(View.INVISIBLE);
        } else {
            adapter.setFilteredList(filteredList);
        }
    }

    private void showData() {

        dbRef = reference.child("শাক-সবজি চাষ");
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
                        VegetableData data = snapshot.getValue(VegetableData.class);
                        listagricultureinformation.add(data);
                    }
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(new LinearLayoutManager(VegetableActivity.this));
                    adapter = new VegetableAdapter(VegetableActivity.this, listagricultureinformation, "শাক-সবজি চাষ");
                    recyclerView.setAdapter(adapter);
                    progressBar.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                progressBar.setVisibility(View.VISIBLE);
                recyclerView.setVisibility(View.INVISIBLE);
                Toast.makeText(VegetableActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}