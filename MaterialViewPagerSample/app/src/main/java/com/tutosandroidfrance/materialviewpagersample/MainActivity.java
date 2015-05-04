package com.tutosandroidfrance.materialviewpagersample;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.github.florent37.materialviewpager.MaterialViewPager;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final int tabCount = 4;

        MaterialViewPager materialViewPager = (MaterialViewPager) findViewById(R.id.materialViewPager);
        materialViewPager.getViewPager().setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return RecyclerViewFragment.newInstance();
            }

            @Override
            public int getCount() {
                return tabCount;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return "Page "+position;
            }
        });

        materialViewPager.getViewPager().setOffscreenPageLimit(tabCount);

        materialViewPager.getPagerTitleStrip().setViewPager(materialViewPager.getViewPager());
    }

}
