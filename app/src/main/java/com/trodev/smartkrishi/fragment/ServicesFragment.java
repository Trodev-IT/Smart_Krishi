package com.trodev.smartkrishi.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DatabaseReference;
import com.trodev.smartkrishi.R;
import com.trodev.smartkrishi.UpazillaServices.RehabilitationActivity;

public class ServicesFragment extends Fragment {


    CardView rehabilitation;

    //DatabaseReference reference, dbRef;

    public ServicesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_services, container, false);


        /*Initial Views*/
        rehabilitation= view.findViewById(R.id.rehabilitation);

        /*onClick Views*/
        rehabilitation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), RehabilitationActivity.class));
            }
        });

        return view;
    }

}