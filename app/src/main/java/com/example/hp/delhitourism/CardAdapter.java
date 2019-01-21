package com.example.hp.delhitourism;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

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
        //this.spacecrafts = spacecrafts;
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

        //BIND
        //temp.name="NSIT";
        //temp.location="Delhi";
        //temp.starRating=4;
        nameTxt.setText(s.getName());
        propTxt.setText(s.getLocation());
        ratingBar.setRating(s.getStarRating());
        //ratingBar.setNumStars(s.getStarRating());
        Picasso.get().load(s.getImageLocation()).into(img);
        //img.setImageResource(temp.starRating);

        /*view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(c, s.getName(), Toast.LENGTH_SHORT).show();
            }
        });*/

        return view;
    }
}
