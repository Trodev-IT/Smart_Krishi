package com.trodev.smartkrishi.weatheractivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.trodev.smartkrishi.R;
import com.trodev.smartkrishi.newsactivity.NewsActivity;
import com.trodev.smartkrishi.newsactivity.NewsAdapter;
import com.trodev.smartkrishi.newsactivity.NewsData;

import java.util.ArrayList;

public class WeatherActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ProgressBar progressBar;
    DatabaseReference reference, dbRef;
    ArrayList<WeatherData> weathernews;
    WeatherAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        getSupportActionBar().setTitle("আবহাওয়া সংবাদ");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView= findViewById(R.id.recyclerView);
        progressBar= findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);

        reference = FirebaseDatabase.getInstance().getReference().child("News");
        showData();

    }

    private void showData() {

        dbRef = reference.child("আবহাওয়া সংবাদ");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                weathernews = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    recyclerView.setVisibility(View.GONE); // change
                } else {
                    recyclerView.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.INVISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        WeatherData data = snapshot.getValue(WeatherData.class);
                        weathernews.add(data);
                    }
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(new LinearLayoutManager(WeatherActivity.this));
                    adapter = new WeatherAdapter(WeatherActivity.this, weathernews, "আবহাওয়া সংবাদ");
                    recyclerView.setAdapter(adapter);
                    progressBar.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                progressBar.setVisibility(View.VISIBLE);
                recyclerView.setVisibility(View.INVISIBLE);
                Toast.makeText(WeatherActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}