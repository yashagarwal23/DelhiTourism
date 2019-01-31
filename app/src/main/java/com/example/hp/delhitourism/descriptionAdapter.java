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
        //this.spacecrafts = spacecrafts;
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
        TouristPlace temp=TP.get(i);
        //holder.placeImage.setImageBitmap(temp.getImage(context));
        holder.placeName.setText(temp.getName());
        holder.placeRating.setNumStars(temp.getStarRating());
        holder.placeLocality.setText(temp.getLocation());
        holder.placeDescription.setText(temp.getDescription());
        holder.placeRating.setRating(temp.getStarRating());
        holder.placeRating.setMax(5);
        /*holder.getMapsIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            /public void onClick(View view) {
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("http://maps.google.com/maps?saddr=20.344,34.34&daddr=20.5666,45.345"));
                //startActivity(intent);
            }
        });*/
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
        }
    }
    /*public descriptionHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflator = LayoutInflater.from(viewGroup.getContext());
        View view = inflator.inflate(R.layout.model, viewGroup, false);
        return new descriptionHolder(view);
    }
    /*@Override
    public int getCount() {
        return TP.size();
    }*/

    /*@Override
    public Object getItem(int i) {
        return spacecrafts.get(i);
    }*/

    /*@Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public Object getItem(int i) {
        return TP.get(i);
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null)
        {
            view= LayoutInflater.from(c).inflate(R.layout.model,viewGroup,false);
        }

        final TouristPlace s= (TouristPlace) this.getItem(i);

        ImageView img= (ImageView) view.findViewById(R.id.placeImage);
        TextView nameTxt= (TextView) view.findViewById(R.id.placeName);
        TextView propTxt= (TextView) view.findViewById(R.id.placeLocality);
        RatingBar ratingBar=(RatingBar) view.findViewById(R.id.placeRating);

        //BIND
        //temp.name="NSIT";
        //temp.location="Delhi";
        //temp.starRating=4;
        propTxt.setText(s.getLocation());
        ratingBar.setRating(s.getStarRating());
        Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/delhitourism-57a77.appspot.com/o/dtu.jpg?alt=media&token=86fe47d4-6e18-42de-8b52-31da122ffcc1").into(img);
        //img.setImageResource(temp.starRating);

        /*view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(c, s.getName(), Toast.LENGTH_SHORT).show();
            }
        });*/

        /*return view;
    }*/
}
