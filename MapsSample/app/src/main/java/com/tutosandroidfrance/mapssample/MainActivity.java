package com.tutosandroidfrance.mapssample;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Map;


public class MainActivity extends ActionBarActivity implements OnMapReadyCallback {

    MapFragment mapFragment;
    GoogleMap map = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.mapFragment);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        this.map = map;
        this.map.setMyLocationEnabled(true);

        afficherTourEiffel();
    }

    public void afficherTourEiffel(){
        LatLng paris = new LatLng(-48.858370099999990000, 2.294481300000029500);
        int zoom = 13;

        this.map.moveCamera(CameraUpdateFactory.newLatLngZoom(paris, zoom));

        this.map.addMarker(new MarkerOptions()
                .title("Paris")
                .snippet("Elle n'est pas belle notre tour effeil ?")
                .position(paris));
    }

}
