package com.example.hp.delhitourism;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.net.URL;

public class touristPlace {
     String name;
     String id;
     URL imageURL;
     String imageLocation;
     int starRating;
     String category;
     String location;
     String description;
     String about;


     private Context context;

     touristPlace(Context context) {
         this.context = context;
     }

     touristPlace()
     {
         name="NSIT";
         id="";
         starRating=4;
         imageLocation="";
         category="";
         location="Delhi";
         description="";
         about="";
     }

    public String getName() {
         return name;
    }

    public int getRating() {
         return starRating;
    }

    public Bitmap getImage() {
         Bitmap image = BitmapFactory.decodeResource(context.getResources(),R.drawable.nsit);
         return image;
    }

    public String getLoacality() {
         return location;
    }
}
