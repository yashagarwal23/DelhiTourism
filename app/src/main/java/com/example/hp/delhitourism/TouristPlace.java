package com.example.hp.delhitourism;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.net.URL;

public class TouristPlace {
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

     public TouristPlace()
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
     public TouristPlace(Context context)
     {
         name="NSIT";
         id="";
         starRating=4;
         imageLocation="";
         category="";
         location="Delhi";
         description="";
         about="";
         this.context = context.getApplicationContext();
     }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
         return name;
    }
    public  void setId(String id)
    {
        this.id=id;
    }
    public String getId()
    {
        return id;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getStarRating() {
        return starRating;
    }

    public String getAbout() {
        return about;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setStarRating(int starRating) {
        this.starRating = starRating;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageLocation() {
        return imageLocation;
    }

    public void setImageLocation(String imageLocation) {
        this.imageLocation = imageLocation;
    }

    public String getLocation() {
        return location;
    }

    public void setImageURL(URL imageURL) {
        this.imageURL = imageURL;
    }
    public Bitmap getImage() {

//         TODO implement the proper method

         Bitmap image = BitmapFactory.decodeResource(context.getResources(),R.drawable.nsit);
         return image;
    }

}
