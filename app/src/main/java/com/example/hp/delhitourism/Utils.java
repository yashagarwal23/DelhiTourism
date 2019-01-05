package com.example.hp.delhitourism;

import android.content.Context;

public class Utils {
    public static TouristPlace[] getTouristPlaces(Context context, String categoryName) {

        //        TODO implement proper method involving database

        TouristPlace[] touristPlaces = new TouristPlace[10];
        for(int i = 0; i < 10; i++) {
            touristPlaces[i] = new TouristPlace(context);
        }

        return touristPlaces;
    }
}
