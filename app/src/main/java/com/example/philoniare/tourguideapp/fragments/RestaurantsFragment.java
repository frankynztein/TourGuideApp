package com.example.philoniare.tourguideapp.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
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

public class RestaurantsFragment extends Fragment {
    @BindView(R.id.list_view_restaurants) ListView restaurantsList;
    private ArrayList<Location> restaurants;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_restaurants, container, false);
        ButterKnife.bind(this, view);

        // Set Title
        ActionBar mainBar = ((AppCompatActivity)getActivity()).getSupportActionBar();
        if (mainBar != null) {
            mainBar.setTitle(getString(R.string.fragment_title_restaurants));
        }

        // Seed the app with attractions data
        restaurants = new ArrayList<>();
        restaurants.add(new Location("Cascal", "https://media-cdn.tripadvisor.com/media/photo-f/02/6d/5f/6b/cascal.jpg"));
        restaurants.add(new Location("Oren's Hummus Shop", "https://media-cdn.tripadvisor.com/media/photo-s/07/65/aa/29/oren-s-hummus-shop.jpg"));
        restaurants.add(new Location("Sakoon", "https://media-cdn.tripadvisor.com/media/photo-f/07/43/a4/ac/profile-pictures.jpg"));
        restaurants.add(new Location("Xanh Restaurant", "https://media-cdn.tripadvisor.com/media/photo-f/02/55/f0/c7/crab.jpg"));
        restaurants.add(new Location("Vive Sol", "https://media-cdn.tripadvisor.com/media/photo-f/03/e6/07/c0/vive-sol.jpg"));
        restaurants.add(new Location("Amber India Restaurant", "https://media-cdn.tripadvisor.com/media/photo-s/07/43/74/9d/profile-pictures.jpg"));
        restaurants.add(new Location("Scratch", "https://media-cdn.tripadvisor.com/media/photo-f/02/9c/12/bc/filename-scratch-3-jpg.jpg"));

        // Connect the adapter with the dataset
        LocationsAdapter restaurantsAdapter = new LocationsAdapter(this.getContext(), restaurants);
        restaurantsList.setAdapter(restaurantsAdapter);
        return view;
    }

}
