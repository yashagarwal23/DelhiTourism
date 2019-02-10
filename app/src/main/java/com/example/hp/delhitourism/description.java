package com.example.hp.delhitourism;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.lsjwzh.widget.recyclerviewpager.RecyclerViewPager;

import java.util.ArrayList;

public class description extends AppCompatActivity {

    int currentPosition=0;
    ArrayList<TouristPlace> touristPlaces;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);
       getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Intent intent = getIntent();
        Bundle args = intent.getBundleExtra("bundle");
        currentPosition=getIntent().getIntExtra("position", 0);
        touristPlaces = (ArrayList<TouristPlace>) args.getSerializable("tourist places");
        getSupportActionBar().setTitle(touristPlaces.get(0).getCategory());

        RecyclerViewPager mRecyclerView = (RecyclerViewPager) findViewById(R.id.list);

// setLayoutManager like normal RecyclerView, you do not need to change any thing.
        LinearLayoutManager layout = new LinearLayoutManager(description.this,LinearLayoutManager.HORIZONTAL,false);
        mRecyclerView.setLayoutManager(layout);
        mRecyclerView.scrollToPosition(currentPosition);

//set adapter
//You just need to implement ViewPageAdapter by yourself like a normal RecyclerView.Adpater.
        mRecyclerView.setAdapter(new descriptionAdapter(description.this,touristPlaces));
    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
