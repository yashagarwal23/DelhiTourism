package com.example.hp.delhitourism.Adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.hp.delhitourism.MainActivity;
import com.example.hp.delhitourism.MapsActivity;
import com.example.hp.delhitourism.R;
import com.example.hp.delhitourism.TouristPlace;
import com.example.hp.delhitourism.Utils;
import com.example.hp.delhitourism.offlineDatabase.databaseAccess;

import java.util.ArrayList;

public class CategoryRecyclerViewAdapter extends RecyclerView.Adapter<CategoryRecyclerViewAdapter.CategoryRecyclerViewHolder> {


    private String categoryNames[];
    private Context context;

    public CategoryRecyclerViewAdapter(String[] categoryNames, Context context) {
        this.categoryNames = categoryNames;
        this.context = context;
    }

    @NonNull
    @Override
    public CategoryRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflator = LayoutInflater.from(viewGroup.getContext());
        View view = inflator.inflate(R.layout.horizontal_list_item, viewGroup, false);
        return new CategoryRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryRecyclerViewHolder holder, int i) {
//        TouristPlace tourisPlaces[] = Utils.getTouristPlaces(context, categoryNames[i]);

        databaseAccess db = databaseAccess.getInstance(context);
        db.open();
        final ArrayList<TouristPlace> temp = db.getTouristPlacesByCategory(categoryNames[i]);
        TouristPlace[] touristPlaces = temp.toArray(new TouristPlace[temp.size()]);

        holder.categoryTextView.setText(categoryNames[i]);
        RecyclerView horizontalRecyclerView = holder.horizontalRecyclerView;
        horizontalRecyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        horizontalRecyclerView.setAdapter(new HorizontalViewAdapter(touristPlaces, context));

        holder.seeOnMapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MapsActivity.class);
                Bundle args = new Bundle();
                args.putSerializable("tourist places", temp);
                intent.putExtra("bundle", args);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryNames.length;
    }

    public class CategoryRecyclerViewHolder extends RecyclerView.ViewHolder {

        TextView categoryTextView;
        RecyclerView horizontalRecyclerView;
        TextView seeOnMapButton;

        public CategoryRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
//            LinearLayout linearLayout = itemView.findViewById(R.id.horizontal_list_linear_layout);
            categoryTextView = itemView.findViewById(R.id.category_text_view);
            horizontalRecyclerView = itemView.findViewById(R.id.horizontal_list);
            seeOnMapButton = itemView.findViewById(R.id.see_on_map_button);
        }
    }
}
