package com.tutosandroidfrance.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by florentchampigny on 10/08/15.
 */
public class MainFragment extends Fragment {

    public interface MainFragmentCallback {
        void onTitleClicked();
    }

    private static final String TITLE = "TITLE";

    public static MainFragment newInstance(String title) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putString(TITLE, title);
        fragment.setArguments(args);
        return fragment;
    }

    TextView title;
    MainFragmentCallback mainFragmentCallback;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof MainFragmentCallback)
            mainFragmentCallback = (MainFragmentCallback) activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mainFragmentCallback = null;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        title = (TextView) view.findViewById(R.id.title);

        Bundle args = getArguments();
        if (args != null) {
            if (args.containsKey(TITLE))
                title.setText(args.getString(TITLE));
        }

        title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mainFragmentCallback != null)
                    mainFragmentCallback.onTitleClicked();
            }
        });
    }

}
