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

import java.util.ArrayList;

public class MapRecyclerViewAdapter extends RecyclerView.Adapter<MapRecyclerViewAdapter.MapRecyclerViewHolder> {

    private ArrayList<TouristPlace> touristPlaces;
    private Context context;

    public MapRecyclerViewAdapter(ArrayList<TouristPlace> touristPlaces, Context context) {
        this.touristPlaces = touristPlaces;
        this.context = context.getApplicationContext();
    }

    @NonNull
    @Override
    public MapRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflator = LayoutInflater.from(viewGroup.getContext());
        View view = inflator.inflate(R.layout.map_card_view, viewGroup, false);
        return new MapRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MapRecyclerViewHolder holder, int i) {
        TouristPlace touristPlace = touristPlaces.get(i);
        holder.placeName.setText(touristPlace.getName());
        holder.placeRating.setNumStars(touristPlace.getStarRating());
        holder.placeCategory.setText(touristPlace.getCategory());
        holder.placeDescription.setText(touristPlace.getDescription());
        holder.placeImage.setImageBitmap(touristPlace.getImage(context));
    }

    @Override
    public int getItemCount() {
        return touristPlaces.size();
    }

    public class MapRecyclerViewHolder extends RecyclerView.ViewHolder {

        ImageView placeImage;
        TextView placeName, placeCategory, placeDescription;
        RatingBar placeRating;

        public MapRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            placeImage = itemView.findViewById(R.id.map_place_image_view);
            placeName = itemView.findViewById(R.id.map_place_name);
            placeRating = itemView.findViewById(R.id.map_place_rating);
            placeCategory = itemView.findViewById(R.id.map_place_category);
            placeDescription = itemView.findViewById(R.id.map_place_description);
        }
    }

}
