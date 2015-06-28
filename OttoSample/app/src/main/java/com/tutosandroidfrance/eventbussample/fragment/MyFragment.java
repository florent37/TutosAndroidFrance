package com.tutosandroidfrance.eventbussample.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.squareup.otto.Subscribe;
import com.tutosandroidfrance.eventbussample.MyBus;
import com.tutosandroidfrance.eventbussample.R;
import com.tutosandroidfrance.eventbussample.event.PleaseRefreshEvent;

/**
 * Created by florentchampigny on 23/06/15.
 */
public class MyFragment extends Fragment{

    TextView textView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment,container,false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView = (TextView) view.findViewById(R.id.text);
    }

    @Override
    public void onStart() {
        super.onStart();
        MyBus.getBus().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        MyBus.getBus().unregister(this);
    }

    //This object can receive a PleaseRefreshEvent
    @Subscribe
    public void onEvent(PleaseRefreshEvent event){
        textView.setText(getString(R.string.refresh));
    }
}
