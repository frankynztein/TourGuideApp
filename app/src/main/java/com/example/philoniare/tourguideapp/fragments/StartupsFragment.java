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

public class StartupsFragment extends Fragment {
    @BindView(R.id.list_view_startups) ListView startupsList;
    private ArrayList<Location> startups;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_startups, container, false);
        ButterKnife.bind(this, view);

        // Set Title
        ActionBar mainBar = ((AppCompatActivity)getActivity()).getSupportActionBar();
        if (mainBar != null) {
            mainBar.setTitle(getString(R.string.fragment_title_startups));
        }

        // Seed the app with attractions data
        startups = new ArrayList<>();
        startups.add(new Location("Udacity", "https://d1qb2nb5cznatu.cloudfront.net/startups/i/113563-0d042ff7bd710ce95c303aa3f93c8522-thumb_jpg.jpg"));
        startups.add(new Location("Google", "https://d1qb2nb5cznatu.cloudfront.net/startups/i/32203-82d0714db762a3e51bfe40bf38acfe52-thumb_jpg.jpg"));
        startups.add(new Location("MediaSpike", "https://d1qb2nb5cznatu.cloudfront.net/startups/i/20332-226e9dbc9884fc0693a521c692646431-thumb_jpg.jpg"));
        startups.add(new Location("Quora", "https://d1qb2nb5cznatu.cloudfront.net/startups/i/33775-6ec9f8384d31c1179bd03c2e1455ca5a-thumb_jpg.jpg"));
        startups.add(new Location("Evernote", "https://d1qb2nb5cznatu.cloudfront.net/startups/i/33233-e5f665ca6221f1a2f391a567f53c3760-thumb_jpg.jpg"));
        startups.add(new Location("Khan Academy", "https://d1qb2nb5cznatu.cloudfront.net/startups/i/67879-1e54a1b0db1468c241867a9814fec14b-thumb_jpg.jpg"));
        startups.add(new Location("Zapier", "https://d1qb2nb5cznatu.cloudfront.net/startups/i/78563-d6a685e956012e72415c2b12769e7459-thumb_jpg.jpg"));

        // Connect the adapter with the dataset
        LocationsAdapter startupsAdapter = new LocationsAdapter(this.getContext(), startups);
        startupsList.setAdapter(startupsAdapter);
        return view;
    }
}
