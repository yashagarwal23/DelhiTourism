package com.example.hp.delhitourism;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class CardAdapter  extends BaseAdapter {
    Context c;
    TouristPlace temp;
    ArrayList<TouristPlace> TP;
    public CardAdapter(Context c, ArrayList<TouristPlace> TP) {
        this.c = c;
        temp=new TouristPlace();
        this.TP=TP;
    }

    @Override
    public int getCount() {
        return TP.size();
    }

    /*@Override
    public Object getItem(int i) {
        return spacecrafts.get(i);
    }*/

    @Override
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
        nameTxt.setText(s.getName());
        propTxt.setText(s.getLocation());
        ratingBar.setRating(s.getStarRating());
        //ratingBar.setNumStars(s.getStarRating());

        Picasso.get().load(s.getImageLocation()).into(img);



        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(c,description.class);
                //myIntent.putExtra("key", value); //Optional parameters
                ArrayList<TouristPlace> touristPlaces = TP;

                Bundle args = new Bundle();
                args.putSerializable("tourist places", TP);
                myIntent.putExtra("bundle", args);
                c.startActivity(myIntent);
            }
        });

        return view;
    }
}
