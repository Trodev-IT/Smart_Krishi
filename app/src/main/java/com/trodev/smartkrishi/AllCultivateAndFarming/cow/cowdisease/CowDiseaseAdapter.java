package com.trodev.smartkrishi.AllCultivateAndFarming.cow.cowdisease;

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

public class CowDiseaseAdapter extends RecyclerView.Adapter<CowDiseaseAdapter.MyViewHolder> {

    public Context context;
    public ArrayList<CowDiseaseData> listanimal;
    public String Category;

    public CowDiseaseAdapter(Context context, ArrayList<CowDiseaseData> listanimal, String category) {
        this.context = context;
        this.listanimal = listanimal;
        Category = category;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.listanimal, parent, false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        CowDiseaseData models = listanimal.get(position);

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
        return listanimal.size();
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
