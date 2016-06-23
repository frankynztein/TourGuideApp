package com.example.philoniare.tourguideapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class TourGuide extends FragmentActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_guide);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // Start Attractions fragment
        startFragment("attractionsFrag");
    }

    public void startFragment(String fragTag) {
        FragmentManager fManager = getSupportFragmentManager();
        FragmentTransaction fTransaction = fManager.beginTransaction();
        Fragment fragment = fManager.findFragmentByTag(fragTag);

        // If fragment doesn't exist yet, create one
        if (fragment == null) {
            switch(fragTag) {
                case "attractionsFrag":
                    fTransaction.add(R.id.main_fragment_container, new AttractionsFragment(), fragTag);
                    break;
                case "parksFrag":
                    fTransaction.add(R.id.main_fragment_container, new ParksFragment(), fragTag);
                    break;
                case "startupsFrag":
                    fTransaction.add(R.id.main_fragment_container, new StartupsFragment(), fragTag);
                    break;
                case "restaurantsFrag":
                    fTransaction.add(R.id.main_fragment_container, new RestaurantsFragment(), fragTag);
                    break;
            }
            fTransaction.commit();
        }
        else {
            // re-use the old fragment, keeping only a single instance of each fragment
            fTransaction.replace(R.id.main_fragment_container, fragment, fragTag);
        }
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        Intent navIntent;
        int id = item.getItemId();

        if (id == R.id.nav_attractions) {
            startFragment("attractionsFrag");
        } else if (id == R.id.nav_startups) {
            startFragment("startupsFrag");
        } else if (id == R.id.nav_parks) {
            startFragment("parksFrag");
        } else {
            startFragment("restaurantsFrag");
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
