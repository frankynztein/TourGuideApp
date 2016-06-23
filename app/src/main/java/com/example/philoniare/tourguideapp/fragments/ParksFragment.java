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

public class ParksFragment extends Fragment {
    @BindView(R.id.list_view_parks) ListView parksList;
    private ArrayList<Location> parks;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_parks, container, false);
        ButterKnife.bind(this, view);

        // Set the Title
        ActionBar mainBar = ((AppCompatActivity)getActivity()).getSupportActionBar();
        if (mainBar != null) {
            mainBar.setTitle(getString(R.string.fragment_title_parks));
        }

        // Seed the app with parks data
        parks = new ArrayList<>();
        parks.add(new Location("Bubb Park", "https://lh3.googleusercontent.com/-92e6EihV6Ds/Vb6hZtOr7SI/AAAAAAABThE/lzfXAWtRwYwf1Npbl084ATeyQzw6J0Z6w/s455-k-no/"));
        parks.add(new Location("Castro Park", "https://geo0.ggpht.com/cbk?panoid=40TBs9mUIZBfbCeGiM3uxA&output=thumbnail&cb_client=search.TACTILE.gps&thumb=2&w=408&h=256&yaw=141.52196&pitch=0"));
        parks.add(new Location("Charleston Park", "https://lh3.googleusercontent.com/-tHmi94Imkh4/V0ukidkfIBI/AAAAAAAAi04/Kx9Zwa6Z2iUhhFsDToNodpVIx9kkIiy9QCLIB/s408-k-no/"));
        parks.add(new Location("Chetwood Park", "https://geo2.ggpht.com/cbk?panoid=puGBm4HtuxXsRSfJmsJvZQ&output=thumbnail&cb_client=search.TACTILE.gps&thumb=2&w=408&h=256&yaw=319.23489&pitch=0"));
        parks.add(new Location("Cooper Park", "https://lh6.googleusercontent.com/proxy/2tdav-jERtXd0gVX9844NhF_wwIXRMIbi6rB2KzENxRujbTEZY8KoRvW-HTWz1AAU2i3pFJGtfDAdq9EQH_l8HPoSaW1CKXXXLOCJ7odguyVcIxuLlW93VZXwVSoGE3iTRLni0KlVRL6Gkp8QIdR48QkFuTlm-4=w408-h305"));
        parks.add(new Location("Creekside Park", "https://lh4.googleusercontent.com/-0-auFhv3kTo/V2dGzlFij_I/AAAAAAAATcw/3iIi6GJwKqIOqPMRIdXAdyn_uyXw54SlwCLIB/w512-h256-n-k-no/"));

        // Connect the adapter with the dataset
        LocationsAdapter parksAdapter = new LocationsAdapter(this.getContext(), parks);
        parksList.setAdapter(parksAdapter);
        return view;
    }
}
