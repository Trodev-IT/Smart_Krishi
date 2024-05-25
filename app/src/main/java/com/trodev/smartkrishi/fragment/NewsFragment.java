package com.trodev.smartkrishi.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.trodev.smartkrishi.R;
import com.trodev.smartkrishi.newsactivity.NewsActivity;
import com.trodev.smartkrishi.weatheractivity.WeatherActivity;

public class NewsFragment extends Fragment {

    ImageView news, weather;
    DatabaseReference reference, dbRef;

    public NewsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_news, container, false);

        news= view.findViewById(R.id.news);
        weather= view.findViewById(R.id.weather);

        news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Agriculture News Portal", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getContext(), NewsActivity.class));
            }
        });

        weather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Weather News Portal", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getContext(), WeatherActivity.class));
            }
        });

        return view;
    }
}