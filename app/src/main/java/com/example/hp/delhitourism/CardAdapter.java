package com.example.hp.delhitourism;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class CardAdapter  extends BaseAdapter {
    Context c;
    TouristPlace temp;
    //ArrayList<Spacecraft> spacecrafts;

    public CardAdapter(Context c) {
        this.c = c;
        temp=new TouristPlace(c);
        //this.spacecrafts = spacecrafts;
    }

    @Override
    public int getCount() {
        return 3;
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
        return temp;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null)
        {
            view= LayoutInflater.from(c).inflate(R.layout.model,viewGroup,false);
        }

        //final Spacecraft s= (Spacecraft) this.getItem(i);

        ImageView img= (ImageView) view.findViewById(R.id.placeImage);
        TextView nameTxt= (TextView) view.findViewById(R.id.placeName);
        TextView propTxt= (TextView) view.findViewById(R.id.placeLocality);
        RatingBar ratingBar=(RatingBar) view.findViewById(R.id.placeRating);

        //BIND
        //temp.name="NSIT";
        //temp.location="Delhi";
        //temp.starRating=4;
        nameTxt.setText(temp.name);
        propTxt.setText(temp.location);
        ratingBar.setRating(temp.starRating);
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
