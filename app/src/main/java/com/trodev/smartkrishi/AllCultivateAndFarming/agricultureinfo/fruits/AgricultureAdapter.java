package com.trodev.smartkrishi.AllCultivateAndFarming.agricultureinfo.fruits;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.trodev.smartkrishi.R;

import java.util.ArrayList;

public class AgricultureAdapter extends RecyclerView.Adapter<AgricultureAdapter.MyViewHolder> {

    public Context context;
    public ArrayList<AgricultureData> list;
    public String Category;

    public AgricultureAdapter(Context context, ArrayList<AgricultureData> list, String category) {
        this.context = context;
        this.list = list;
        Category = category;
    }

    @NonNull
    @Override
    public AgricultureAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.list, parent, false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull AgricultureAdapter.MyViewHolder holder, int position) {

        AgricultureData models = list.get(position);

        holder.nameTv.setText(models.getName());
        try {
            Picasso.get().load(models.getImage()).into(holder.imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView nameTv;
        ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            nameTv = itemView.findViewById(R.id.nameTv);
            imageView = itemView.findViewById(R.id.imageIv);

        }
    }
}
