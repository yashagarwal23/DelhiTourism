package com.example.hp.delhitourism;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.example.hp.delhitourism.offlineDatabase.databaseAccess;

import java.util.ArrayList;

public class Utils extends AppCompatActivity {

    public static TouristPlace[] getTouristPlaces(Context context, String categoryName) {

        //        TODO implement proper method involving database


        TouristPlace[] touristPlaces = new TouristPlace[10];
        for(int i = 0; i < 10; i++) {
            touristPlaces[i] = new TouristPlace();
        }

        return touristPlaces;
    }
}
