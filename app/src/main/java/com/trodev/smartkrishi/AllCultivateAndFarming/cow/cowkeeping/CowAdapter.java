package com.trodev.smartkrishi.AllCultivateAndFarming.cow.cowkeeping;

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

public class CowAdapter extends RecyclerView.Adapter<com.trodev.smartkrishi.AllCultivateAndFarming.cow.cowkeeping.CowAdapter.MyViewHolder> {

    public Context context;
    public ArrayList<CowData> listanimal;
    public String Category;

    public CowAdapter(Context context, ArrayList<CowData> listanimal, String category) {
        this.context = context;
        this.listanimal = listanimal;
        Category = category;
    }

    @NonNull
    @Override
    public com.trodev.smartkrishi.AllCultivateAndFarming.cow.cowkeeping.CowAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.listanimal, parent, false);
        return new com.trodev.smartkrishi.AllCultivateAndFarming.cow.cowkeeping.CowAdapter.MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        CowData models = listanimal.get(position);

        holder.nameTv.setText(models.getName());
        try {
            Picasso.get().load(models.getImage()).into(holder.imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return listanimal.size();
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
