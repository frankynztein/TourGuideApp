package com.example.philoniare.tourguideapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.philoniare.tourguideapp.R;
import com.example.philoniare.tourguideapp.model.Location;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LocationsAdapter extends ArrayAdapter<Location> {
    @BindView(R.id.location_name) TextView locationName;
    @BindView(R.id.location_image) ImageView locationImage;
    private Context mContext;

    public LocationsAdapter(Context context, ArrayList<Location> locations) {
        super(context, 0, locations);
        this.mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Location location = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.location_item, parent, false);
        }
        ButterKnife.bind(this, convertView);
        // Populate the data into the template view using the data object
        locationName.setText(location.getName());
        Picasso.with(mContext).load(location.getImageUrl()).into(locationImage);
        // Return the completed view to render on screen
        return convertView;
    }
}
