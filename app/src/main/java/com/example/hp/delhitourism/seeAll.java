package com.example.hp.delhitourism;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.GridView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import com.example.hp.delhitourism.offlineDatabase.databaseAccess;
import com.google.android.gms.maps.model.LatLng;

public class seeAll extends AppCompatActivity {

    ArrayList<TouristPlace> TP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_all);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        databaseAccess da= databaseAccess.getInstance(getApplicationContext());
        da.open();
        int n=da.getCount();
        TP =new ArrayList<TouristPlace>();

        for(int i=1;i<=n;i++)
        {
            TouristPlace temp=da.getPlace(i);
            TP.add(temp);
        }
        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new CardAdapter(this,TP));
        gridview.setNumColumns(2);

    }

    public ArrayList<TouristPlace> getTP() {
        return TP;
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
