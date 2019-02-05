package com.example.hp.delhitourism;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatRatingBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.lsjwzh.widget.recyclerviewpager.RecyclerViewPager;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private static final int RequestLocation = 100;
    private GoogleMap mMap;
    private ArrayList<TouristPlace> touristPlaces;
    private ArrayList<Marker> markers;
    private RecyclerViewPager horizontalRecyclerView;
    private HashMap<Marker, Integer> markerHash = new HashMap<>();
    private ImageButton googleMapsButton;
    private Location currentLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        Intent intent = getIntent();
        Bundle args = intent.getBundleExtra("bundle");
        touristPlaces = (ArrayList<TouristPlace>) args.getSerializable("tourist places");

        googleMapsButton = findViewById(R.id.google_maps_button);
        googleMapsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager)horizontalRecyclerView.getLayoutManager();
                int pos = linearLayoutManager.findFirstCompletelyVisibleItemPosition();

                String map = "http://maps.google.co.in/maps?q=" + touristPlaces.get(pos).getName() + ", New Delhi";

                Uri gmmIntentUri = Uri.parse(map);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                }
            }
        });

        initialiseRecyclerView();

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    void initialiseRecyclerView() {

        horizontalRecyclerView = (RecyclerViewPager) findViewById(R.id.mapRecyclerView);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        horizontalRecyclerView.setLayoutManager(layoutManager);
        horizontalRecyclerView.setAdapter(new MapRecyclerViewAdapter(touristPlaces, this));

        final SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(horizontalRecyclerView);

        horizontalRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                googleMapsButton.setVisibility(View.GONE);
                if(newState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE) {
                    View centerView = snapHelper.findSnapView(layoutManager);
                    if (centerView != null) {
                        int pos = layoutManager.getPosition(centerView);
                        updateMapPosition(pos);
                    }
                    googleMapsButton.setVisibility(View.VISIBLE);
                }
            }

            private void updateMapPosition(int pos) {
                if(mMap != null) {
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(markers.get(pos).getPosition(), 14));
                    markers.get(pos).showInfoWindow();
                }
            }
        });
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        showCurrentLocationButton();

        markers = new ArrayList<>();

        for(int i = 0; i < touristPlaces.size(); i++) {
            LatLng marker = touristPlaces.get(i).getCoordinates();
            System.out.println("Added Marker");
            Marker locationMarker = mMap.addMarker(new MarkerOptions().position(marker).title(touristPlaces.get(i).getName()).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
            markers.add(locationMarker);
            markerHash.put(locationMarker, i);
        }

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {

//                TODO Add the google maps direction button

                marker.showInfoWindow();
                googleMapsButton.setVisibility(View.VISIBLE);
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(marker.getPosition(), 14));
                if(markerHash.containsKey(marker))
                    horizontalRecyclerView.scrollToPosition(markerHash.get(marker));
                return true;
            }
        });
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(markers.get(0).getPosition(), 14));
        markers.get(0).showInfoWindow();
        googleMapsButton.setVisibility(View.VISIBLE);
    }

    private void showCurrentLocationButton() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if(checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                mMap.setMyLocationEnabled(true);
            }
            else {
                requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, RequestLocation);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == RequestLocation) {
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                mMap.setMyLocationEnabled(true);
            } else {

            }
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }




    class MapRecyclerViewAdapter extends RecyclerView.Adapter<MapRecyclerViewAdapter.MapRecyclerViewHolder> {

        private ArrayList<TouristPlace> touristPlaces;
        private Context context;

        public MapRecyclerViewAdapter(ArrayList<TouristPlace> touristPlaces, Context context) {
            this.touristPlaces = touristPlaces;
            this.context = context.getApplicationContext();
        }

        @NonNull
        @Override
        public MapRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            LayoutInflater inflator = LayoutInflater.from(viewGroup.getContext());
            View view = inflator.inflate(R.layout.map_card_view, viewGroup, false);
            return new MapRecyclerViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MapRecyclerViewHolder holder, int i) {
            TouristPlace touristPlace = touristPlaces.get(i);
            holder.placeName.setText(touristPlace.getName());
            holder.placeRating.setNumStars(touristPlace.getStarRating());
            holder.placeCategory.setText(touristPlace.getCategory());
            holder.placeDescription.setText(touristPlace.getDescription());
            holder.placeLocality.setText(touristPlace.getLocation());

//            TODO implement proper placeDistance
            holder.placeDistance.setText("1 Km");

            Picasso.get().load(touristPlace.getImageLocation()).into(holder.placeImage);
        }

        @Override
        public int getItemCount() {
            return touristPlaces.size();
        }

        public class MapRecyclerViewHolder extends RecyclerView.ViewHolder {

            ImageView placeImage;
            TextView placeName, placeCategory, placeDescription, placeLocality, placeDistance;
            RatingBar placeRating;

            public MapRecyclerViewHolder(@NonNull View itemView) {
                super(itemView);
                placeImage = itemView.findViewById(R.id.map_place_image_view);
                placeName = itemView.findViewById(R.id.map_place_name);
                placeRating = (AppCompatRatingBar) itemView.findViewById(R.id.map_place_rating);
                placeCategory = itemView.findViewById(R.id.map_place_category);
                placeDescription = itemView.findViewById(R.id.map_place_description);
                placeLocality = itemView.findViewById(R.id.locality_text_view);
                placeDistance = itemView.findViewById(R.id.distance_text_view);
            }
        }
    }
}
