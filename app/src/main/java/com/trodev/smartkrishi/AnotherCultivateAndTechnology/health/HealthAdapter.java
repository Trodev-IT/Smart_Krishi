package com.trodev.smartkrishi.AnotherCultivateAndTechnology.health;

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

public class HealthAdapter extends RecyclerView.Adapter<HealthAdapter.MyViewHolder> {
    public Context context;
    public ArrayList<HealthData> listanother;
    public String Category;

    public HealthAdapter(Context context, ArrayList<HealthData> listanother, String category) {
        this.context = context;
        this.listanother = listanother;
        Category = category;
    }

    @NonNull
    @Override
    public HealthAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.listanother, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HealthAdapter.MyViewHolder holder, int position) {
        HealthData models = listanother.get(position);

        holder.nameTv.setText(models.getName());
        try {
            Picasso.get().load(models.getImage()).into(holder.imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return listanother.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nameTv;
        ImageView imageView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            nameTv= itemView.findViewById(R.id.nameTv);
            imageView= itemView.findViewById(R.id.imageIv);
        }
    }
}
