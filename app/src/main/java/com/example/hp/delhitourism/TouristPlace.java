package com.example.hp.delhitourism;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.android.gms.maps.model.LatLng;

import java.io.Serializable;
import java.net.URL;

public class TouristPlace implements Serializable {
    private String name;
    private String id;
    private URL imageURL;
    private String imageLocation;
    private int starRating;
    private String category;
    private String location;
    private String description;
    private String about;
    private double latitude;
    private double longitude;

    public TouristPlace() {
        name = "NSIT";
        id = "";
        starRating = 4;
        imageLocation = "";
        category = "";
        location = "Delhi";
        description = "";
        about = "";
    }

    public URL getImageURL() {
        return imageURL;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
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

    public void setStarRating(double starRating) {
        this.starRating = (int)starRating;
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

    public void setLatitude(double latitude)
    {
        this.latitude=latitude;
    }

    public  void setLongitude(double longitude)
    {
        this.longitude=longitude;
    }
    public Bitmap getImage(Context context) {

//         TODO implement the proper method

        Bitmap image = BitmapFactory.decodeResource(context.getResources(), R.drawable.nsit);
        return image;
    }

    public void setCoordinates(LatLng coordinates) {
        latitude = coordinates.latitude;
        longitude = coordinates.longitude;
    }

    public LatLng getCoordinates() {
        return new LatLng(latitude, longitude);
    }

}
