package com.trodev.smartkrishi.fragment;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.firebase.database.DatabaseReference;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;
import com.trodev.smartkrishi.AllCultivateAndFarming.agricultureinformation.AgricultureInformationActivity;
import com.trodev.smartkrishi.AllCultivateAndFarming.cow.CowActivity;
import com.trodev.smartkrishi.AllCultivateAndFarming.fish.FishActivity;
import com.trodev.smartkrishi.AllCultivateAndFarming.hen.HensActivity;
import com.trodev.smartkrishi.AnotherCultivateAndTechnology.agriculturetechnology.AgricultureTechnologyActivity;
import com.trodev.smartkrishi.AnotherCultivateAndTechnology.anothernews.AnotherNewsActivity;
import com.trodev.smartkrishi.AnotherCultivateAndTechnology.business.BusinessActivity;
import com.trodev.smartkrishi.AnotherCultivateAndTechnology.environment.EnvironmentActivity;
import com.trodev.smartkrishi.AnotherCultivateAndTechnology.health.HealthActivity;
import com.trodev.smartkrishi.AnotherCultivateAndTechnology.success.SuccessActivity;
import com.trodev.smartkrishi.R;
import com.trodev.smartkrishi.SlidersAdapter;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    RecyclerView recyclerView;
    SliderView sliderView;
    CardView farmer, fish, cow, hen, health, business, technology, success, environment, anothernews ;
    DatabaseReference reference;

    int[] images = {R.drawable.bg_img_01,
            R.drawable.bg_img_02,
            R.drawable.bg_img_03,
            R.drawable.bg_img_04,
            R.drawable.bg_img_05,
            R.drawable.bg_img_06,
            R.drawable.bg_img_07,
            R.drawable.bg_img_08,
            R.drawable.bg_img_09,
            R.drawable.bg_img_10,
    };
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
        //recyclerView= view.findViewById(R.id.recyclerView);
        sliderView = view.findViewById(R.id.image_slider);

        SlidersAdapter sliderAdapter = new SlidersAdapter(images);

        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        sliderView.startAutoCycle();

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
                startActivity(new Intent(getContext(), BusinessActivity.class));
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