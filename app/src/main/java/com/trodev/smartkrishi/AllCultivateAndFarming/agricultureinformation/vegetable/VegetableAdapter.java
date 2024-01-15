package com.trodev.smartkrishi.AllCultivateAndFarming.agricultureinformation.vegetable;

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
import com.trodev.smartkrishi.activity.ShowPDFActivity;
import com.trodev.smartkrishi.R;

import java.util.ArrayList;

public class VegetableAdapter extends RecyclerView.Adapter<VegetableAdapter.MyViewHolder> {
    public Context context;
    public ArrayList<VegetableData> listagricultureinformation;
    public String Category;

    public VegetableAdapter(Context context, ArrayList<VegetableData> listagricultureinformation, String category) {
        this.context = context;
        this.listagricultureinformation = listagricultureinformation;
        Category = category;
    }

    @NonNull
    @Override
    public VegetableAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.listagricultureinformation, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        VegetableData models = listagricultureinformation.get(position);

        holder.nameTv.setText(models.getName());
        try {
            Picasso.get().load(models.getImage()).into(holder.imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*Showing PDF by onClick to cardView*/
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(context, ShowPDFActivity.class);
                intent.putExtra("pdf", models.getPdf());
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                context.startActivity(intent);
            }
        });
        /*animation view with slider*/
        holder.cardView.startAnimation(AnimationUtils.loadAnimation(holder.itemView.getContext(), R.anim.slider));


    }

    @Override
    public int getItemCount() {
        return listagricultureinformation.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nameTv;
        ImageView imageView;
        CardView cardView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            nameTv = itemView.findViewById(R.id.nameTv);
            imageView = itemView.findViewById(R.id.imageIv);
            cardView= itemView.findViewById(R.id.cardView);

        }
    }
}
