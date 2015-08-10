package com.tutosandroidfrance.fragments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MainFragment.MainFragmentCallback{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentLayout, MainFragment.newInstance("Mon nouveau titre"))
                .commit();
    }

    @Override
    public void onTitleClicked() {
        //votre action, ici ce sera un simple Toast
        Toast.makeText(this,"Tu as clické !",Toast.LENGTH_SHORT).show();
    }
}
