package com.example.philoniare.tourguideapp.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.philoniare.tourguideapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StartupsFragment extends Fragment {
    @BindView(R.id.list_view_startups) ListView startupsList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_startups, container, false);
        ButterKnife.bind(this, view);
        return view;
    }
}
