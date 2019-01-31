package com.example.hp.delhitourism.Adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.hp.delhitourism.R;
import com.example.hp.delhitourism.TouristPlace;
import com.example.hp.delhitourism.description;
import com.example.hp.delhitourism.seeAll;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HorizontalViewAdapter extends RecyclerView.Adapter<HorizontalViewAdapter.HorizontalViewHolder> {

    private TouristPlace[] data;
    private Context context;

    public HorizontalViewAdapter(TouristPlace[] data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public HorizontalViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflator = LayoutInflater.from(viewGroup.getContext());
        View view = inflator.inflate(R.layout.model, viewGroup, false);
        return new HorizontalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalViewHolder holder, final int i) {
//        holder.placeImage.setImageBitmap(data[i].getImage(context));
        Picasso.get().load(data[i].getImageLocation()).into(holder.placeImage);
        holder.placeName.setText(data[i].getName());
        holder.placeRating.setNumStars(data[i].getStarRating());
        holder.placeLocality.setText(data[i].getLocation());
        holder.placeCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(context, description.class);
                ArrayList<TouristPlace> touristPlaces = new ArrayList<>();
                touristPlaces.add(data[i]);
                Bundle args = new Bundle();
                args.putSerializable("tourist places", touristPlaces);
                myIntent.putExtra("bundle", args);
                context.startActivity(myIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class HorizontalViewHolder extends RecyclerView.ViewHolder {

        CardView placeCardView;
        ImageView placeImage;
        TextView placeName, placeLocality;
        RatingBar placeRating;

        public HorizontalViewHolder(@NonNull View itemView) {
            super(itemView);
            placeCardView = itemView.findViewById(R.id.touristplace_cardview);
            placeImage = itemView.findViewById(R.id.placeImage);
            placeName = itemView.findViewById(R.id.placeName);
            placeLocality = itemView.findViewById(R.id.placeLocality);
            placeRating = itemView.findViewById(R.id.placeRating);
        }
    }
}
