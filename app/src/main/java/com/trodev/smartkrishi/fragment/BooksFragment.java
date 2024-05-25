package com.trodev.smartkrishi.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.trodev.smartkrishi.R;
import com.trodev.smartkrishi.newsactivity.NewsActivity;

import java.util.ArrayList;

public class BooksFragment extends Fragment {

    RecyclerView recyclerView;
    ProgressBar progressBar;
    ArrayList<BooksFragmentData> books;
    BooksFragmentAdapter adapter;
    FirebaseDatabase database;
    DatabaseReference reference, databaseReference;

    public BooksFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_books, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        progressBar = view.findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);

        //database = FirebaseDatabase.getInstance();
        reference = FirebaseDatabase.getInstance().getReference().child("Books");

        /*gridview layout manager*/
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setAdapter(adapter);
        progressBar.setVisibility(View.VISIBLE);

        databaseReference= reference.child("কৃষি হাত বই");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                books = new ArrayList<>();
                if (!snapshot.exists()) {
                    recyclerView.setVisibility(View.GONE); // change
                } else {
                    recyclerView.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.INVISIBLE);

                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        BooksFragmentData data = dataSnapshot.getValue(BooksFragmentData.class);
                        books.add(data);
                    }
                    recyclerView.setHasFixedSize(true);
                    adapter = new BooksFragmentAdapter(getContext(), books, "কৃষি হাত বই");
                    recyclerView.setAdapter(adapter);
                    progressBar.setVisibility(View.INVISIBLE);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                progressBar.setVisibility(View.VISIBLE);
                recyclerView.setVisibility(View.INVISIBLE);
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
//        /*database synced*/
//        databaseReference.keepSynced(true);

        return view;
    }
}