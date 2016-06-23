package com.example.philoniare.tourguideapp.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.philoniare.tourguideapp.R;
import com.example.philoniare.tourguideapp.adapter.LocationsAdapter;
import com.example.philoniare.tourguideapp.model.Location;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AttractionsFragment extends Fragment {
    @BindView(R.id.list_view_attractions) ListView attractionsList;
    private ArrayList<Location> attractions;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_attractions, container, false);
        ButterKnife.bind(this, view);


        // Seed the app with attractions data
        attractions = new ArrayList<>();
        attractions.add(new Location("Computer History Museum", "https://media-cdn.tripadvisor.com/media/photo-s/02/1f/a3/d4/filename-horton-chm-334.jpg"));
        attractions.add(new Location("Stevens Creek Trail", "https://media-cdn.tripadvisor.com/media/photo-s/04/a5/3c/7b/stevens-creek-trail.jpg"));
        attractions.add(new Location("Google Android Lawn Statues", "https://media-cdn.tripadvisor.com/media/photo-s/08/bb/a2/33/google-android-lawn-statues.jpg"));
        attractions.add(new Location("Mountain View Farmers Market", "https://media-cdn.tripadvisor.com/media/photo-s/02/d8/13/8e/mountain-view-farmers.jpg"));
        attractions.add(new Location("NASA Ames Visitor Center", "https://media-cdn.tripadvisor.com/media/photo-s/02/57/1a/8c/model-of-atlantis.jpg"));
        attractions.add(new Location("Shoreline Amphitheatre", "https://media-cdn.tripadvisor.com/media/photo-s/04/2a/26/05/shoreline-amphitheatre.jpg"));
        attractions.add(new Location("Moffett Field Historical Society Museum", "hhttps://media-cdn.tripadvisor.com/media/photo-s/04/76/6a/77/moffett-field-historical.jpg"));

        // Connect the adapter with the dataset
        LocationsAdapter attractionsAdapter = new LocationsAdapter(this.getContext(), attractions);
        attractionsList.setAdapter(attractionsAdapter);
        return view;
    }
}
