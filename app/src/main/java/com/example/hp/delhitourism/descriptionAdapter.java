package com.example.hp.delhitourism;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.hp.delhitourism.Adapters.HorizontalViewAdapter;
import com.google.android.gms.maps.model.LatLng;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class descriptionAdapter extends RecyclerView.Adapter<descriptionAdapter.descriptionHolder> {
    Context context;
    TouristPlace temp;
    ArrayList<TouristPlace> TP;
    public descriptionAdapter(Context c, ArrayList<TouristPlace> TP) {
        this.context = c;
        temp=new TouristPlace();
        this.TP=TP;
    }
    @NonNull
    @Override
    public descriptionHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflator = LayoutInflater.from(viewGroup.getContext());
        View view = inflator.inflate(R.layout.description_xml, viewGroup, false);
        return new descriptionHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull descriptionHolder holder, int i) {
        final TouristPlace temp=TP.get(i);
        //holder.placeImage.setImageBitmap(temp.getImage(context));
        holder.placeName.setText(temp.getName());
        holder.placeRating.setNumStars(temp.getStarRating());
        holder.placeLocality.setText(temp.getLocation());
        holder.placeDescription.setText(temp.getDescription());
        holder.placeRating.setRating(temp.getStarRating());
        //holder.placeRating.setNumStars(5);
        //holder.placeRating.setMax(5);
        holder.getMapsIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LatLng latlng =temp.getCoordinates();
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("http://maps.google.com/maps?daddr="+latlng.latitude+","+latlng.longitude));
                context.startActivity(intent);
            }
        });
        Picasso.get().load(temp.getImageLocation()).into(holder.placeImage);

    }

    @Override
    public int getItemCount() {
        return TP.size();
    }

    public class descriptionHolder extends RecyclerView.ViewHolder {

        ImageView placeImage;
        TextView placeName, placeLocality,placeDescription;
        RatingBar placeRating;
        FloatingActionButton getMapsIntent;

        public descriptionHolder(@NonNull View itemView) {
            super(itemView);
            placeImage = itemView.findViewById(R.id.placeImage);
            placeName = itemView.findViewById(R.id.placeName);
            placeLocality = itemView.findViewById(R.id.placeLocality);
            placeRating = itemView.findViewById(R.id.placeRating);
            placeDescription=itemView.findViewById(R.id.placeDescription);
            getMapsIntent = itemView.findViewById(R.id.displayMaps);
            getMapsIntent.setImageResource(R.drawable.googlemap);
        }
    }

}
