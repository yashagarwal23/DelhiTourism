package com.example.hp.delhitourism.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.hp.delhitourism.R;
import com.example.hp.delhitourism.TouristPlace;
import com.squareup.picasso.Picasso;

public class HorizontalViewAdapter extends RecyclerView.Adapter<HorizontalViewAdapter.HorizontalViewHolder> {

    private TouristPlace[] data;
    private Context context;

    public HorizontalViewAdapter(TouristPlace[] data, Context context) {
        this.data = data;
        this.context = context.getApplicationContext();
    }

    @NonNull
    @Override
    public HorizontalViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflator = LayoutInflater.from(viewGroup.getContext());
        View view = inflator.inflate(R.layout.model, viewGroup, false);
        return new HorizontalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalViewHolder holder, int i) {
//        holder.placeImage.setImageBitmap(data[i].getImage(context));
        Picasso.get().load(data[i].getImageLocation()).into(holder.placeImage);
        holder.placeName.setText(data[i].getName());
        holder.placeRating.setNumStars(data[i].getStarRating());
        holder.placeLocality.setText(data[i].getLocation());
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class HorizontalViewHolder extends RecyclerView.ViewHolder {

        ImageView placeImage;
        TextView placeName, placeLocality;
        RatingBar placeRating;

        public HorizontalViewHolder(@NonNull View itemView) {
            super(itemView);
            placeImage = itemView.findViewById(R.id.placeImage);
            placeName = itemView.findViewById(R.id.placeName);
            placeLocality = itemView.findViewById(R.id.placeLocality);
            placeRating = itemView.findViewById(R.id.placeRating);
        }
    }
}
