package com.tutosandroidfrance.swiperefreshlayoutsample;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity implements SwipeRefreshLayout.OnRefreshListener {

    List<String> strings = new ArrayList<String>();

    ListView mListView;
    SwipeRefreshLayout mSwipeRefreshLayout;
    ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.listView);
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        mSwipeRefreshLayout.setOnRefreshListener(this);

        for(int i=0;i<20;++i)
            strings.add("Element "+i);

        mAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, strings);
        mListView.setAdapter(mAdapter);
    }

    @Override
    public void onRefresh() {
        //appellé lors de l'action PullToRefresh

        mSwipeRefreshLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                //appellé après 2000 ms

                //vide la liste
                strings.clear();

                //puis ajoute les nouveaux elements
                for(int i=0;i<20;++i)
                    strings.add("NouvelElement "+i);

                //annonce à l'adapter que les données ont changés
                mAdapter.notifyDataSetChanged();

                //avertie le SwipeRefreshLayout que la mise à jour a été effectuée
                mSwipeRefreshLayout.setRefreshing(false);
            }
        },2000);
    }
}
