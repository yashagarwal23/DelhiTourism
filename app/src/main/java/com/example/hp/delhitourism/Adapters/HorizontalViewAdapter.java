package com.example.hp.delhitourism.Adapters;

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

public class HorizontalViewAdapter extends RecyclerView.Adapter<HorizontalViewAdapter.HorizontalViewHolder> {

    private TouristPlace[] data;

    public HorizontalViewAdapter(TouristPlace[] data) {
        this.data = data;
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
        holder.placeImage.setImageBitmap(data[i].getImage());
        holder.placeName.setText(data[i].getName());
        holder.placeRating.setNumStars(data[i].getRating());
        holder.placeLocality.setText(data[i].getLoacality());
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
