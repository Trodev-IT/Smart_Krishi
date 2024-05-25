package com.trodev.smartkrishi.fragment;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.trodev.smartkrishi.R;
import com.trodev.smartkrishi.activity.ShowPDFActivity;

import java.util.ArrayList;

public class BooksFragmentAdapter extends RecyclerView.Adapter<BooksFragmentAdapter.MyViewHolder> {
    public Context context;
    public ArrayList<BooksFragmentData> books;
    public String Category;

    public BooksFragmentAdapter(Context context, ArrayList<BooksFragmentData> books, String category) {
        this.context = context;
        this.books = books;
        Category = category;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.books, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        BooksFragmentData data = books.get(position);

        holder.bookname.setText(data.getName());
        try {
            Picasso.get().load(data.getImage()).into(holder.image);
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*Showing PDF by onClick to cardView*/
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(context, ShowPDFActivity.class);
                intent.putExtra("pdf", data.getPdf());
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                context.startActivity(intent);
            }
        });
        /*animation view with slider*/
        holder.cardView.startAnimation(AnimationUtils.loadAnimation(holder.itemView.getContext(), R.anim.slider));

    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView bookname;
        ImageView image;
        CardView cardView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            bookname= itemView.findViewById(R.id.bookname);
            image= itemView.findViewById(R.id.image);
            cardView= itemView.findViewById(R.id.cardView);
        }
    }
}
