package com.trodev.smartkrishi.AllCultivateAndFarming.fish.nativefish;


import android.content.Context;
import android.sax.StartElementListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.trodev.smartkrishi.AllCultivateAndFarming.cow.cowkeeping.CowData;
import com.trodev.smartkrishi.R;

import java.util.ArrayList;

public class NativeFishAdapter extends RecyclerView.Adapter<com.trodev.smartkrishi.AllCultivateAndFarming.fish.nativefish.NativeFishAdapter.MyViewHolder> {

    public Context context;
    public ArrayList<NativeFishData> listfishl;
    public String Category;

    public NativeFishAdapter(Context context, ArrayList<NativeFishData> listfishl, String category) {
        this.context = context;
        this.listfishl = listfishl;
        Category = category;
    }

    @NonNull
    @Override
    public com.trodev.smartkrishi.AllCultivateAndFarming.fish.nativefish.NativeFishAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.listfishl, parent, false);
        return new com.trodev.smartkrishi.AllCultivateAndFarming.fish.nativefish.NativeFishAdapter.MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        NativeFishData models = listfishl.get(position);

        holder.nameTv.setText(models.getName());
        try {
            Picasso.get().load(models.getImage()).into(holder.imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Override
    public int getItemCount() {
        return listfishl.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView nameTv;
        ImageView imageView, arrow;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            nameTv = itemView.findViewById(R.id.nameTv);
            imageView = itemView.findViewById(R.id.imageIv);
            arrow= itemView.findViewById(R.id.arrow);

            arrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

        }
    }
}
