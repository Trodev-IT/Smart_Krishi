package com.trodev.smartkrishi.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DatabaseReference;
import com.trodev.smartkrishi.AllCultivateAndFarming.agricultureinformation.AgricultureInformationActivity;
import com.trodev.smartkrishi.AllCultivateAndFarming.cow.CowActivity;
import com.trodev.smartkrishi.AllCultivateAndFarming.fish.FishActivity;
import com.trodev.smartkrishi.AllCultivateAndFarming.hen.HensActivity;
import com.trodev.smartkrishi.AnotherCultivateAndTechnology.agriculturetechnology.AgricultureTechnologyActivity;
import com.trodev.smartkrishi.AnotherCultivateAndTechnology.anothernews.AnotherNewsActivity;
import com.trodev.smartkrishi.AnotherCultivateAndTechnology.business.BusninessActivity;
import com.trodev.smartkrishi.AnotherCultivateAndTechnology.environment.EnvironmentActivity;
import com.trodev.smartkrishi.AnotherCultivateAndTechnology.health.HealthActivity;
import com.trodev.smartkrishi.AnotherCultivateAndTechnology.success.SuccessActivity;
import com.trodev.smartkrishi.R;


public class HomeFragment extends Fragment {

    RecyclerView recyclerView;
    CardView farmer, fish, cow, hen, health, business, technology, success, environment, anothernews ;
//    ArrayList<AdviceModel> model;
//    AdviceAdapter adapter;
    DatabaseReference reference;
    public HomeFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);

        /*finding all items*/

        farmer= view.findViewById(R.id.farmer);
        fish= view.findViewById(R.id.fish);
        cow= view.findViewById(R.id.cow);
        hen= view.findViewById(R.id.hen);
        health= view.findViewById(R.id.health);
        business= view.findViewById(R.id.business);
        technology= view.findViewById(R.id.technology);
        success= view.findViewById(R.id.success);
        environment= view.findViewById(R.id.environment);
        anothernews= view.findViewById(R.id.anothernews);
        recyclerView= view.findViewById(R.id.recyclerView);

        /*set on click listener*/
        farmer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), AgricultureInformationActivity.class));
            }
        });
        fish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), FishActivity.class));

            }
        });
        cow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), CowActivity.class));

            }
        });
        hen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), HensActivity.class));

            }
        });
        health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), HealthActivity.class));
            }
        });
        business.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), BusninessActivity.class));
            }
        });
        technology.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), AgricultureTechnologyActivity.class));
            }
        });
        success.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), SuccessActivity.class));
            }
        });
        environment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), EnvironmentActivity.class));
            }
        });
        anothernews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), AnotherNewsActivity.class));
            }
        });
        return view;

    }
}