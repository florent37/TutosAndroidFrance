package com.tutosandroidfrance.designsupporttest;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Explode;
import android.transition.Fade;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tutosandroidfrance.designsupporttest.model.MyObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by florentchampigny
 */
public class RecyclerViewFragment extends Fragment implements RecyclerViewAdapter.RecyclerViewAdapterCallBack {

    @InjectView(R.id.recyclerView)
    RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;

    public static RecyclerViewFragment newInstance() {
        return new RecyclerViewFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recyclerview, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ButterKnife.inject(this, view);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        adapter = new RecyclerViewAdapter(this);
        adapter.addObjects(createObjects());

        recyclerView.setAdapter(adapter);
    }

    private List<MyObject> createObjects() {
        List<MyObject> objects = new ArrayList<>();

        objects.add(new MyObject("France", "http://www.telegraph.co.uk/travel/destination/article130148.ece/ALTERNATES/w620/parisguidetower.jpg"));
        objects.add(new MyObject("Angleterre", "http://www.traditours.com/images/Photos%20Angleterre/ForumLondonBridge.jpg"));
        objects.add(new MyObject("Allemagne", "http://tanned-allemagne.com/wp-content/uploads/2012/10/pano_rathaus_1280.jpg"));
        objects.add(new MyObject("Espagne", "http://www.sejour-linguistique-lec.fr/wp-content/uploads/espagne-02.jpg"));
        objects.add(new MyObject("Italie", "http://retouralinnocence.com/wp-content/uploads/2013/05/Hotel-en-Italie-pour-les-Vacances2.jpg"));
        objects.add(new MyObject("Russie", "http://www.choisir-ma-destination.com/uploads/_large_russie-moscou2.jpg"));


        return objects;
    }

    @Override
    public void onRecyclerViewElementClicked(View view, int position, MyObject element) {
        Intent intent = new Intent(getActivity(), DetailActivity.class);
        intent.putExtra(DetailActivity.MY_OBJECT, element);

        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                getActivity(),
                Pair.create(view.findViewById(R.id.image), getResources().getString(R.string.image))
        );

        ActivityCompat.startActivity(getActivity(), intent, options.toBundle());
    }
}
