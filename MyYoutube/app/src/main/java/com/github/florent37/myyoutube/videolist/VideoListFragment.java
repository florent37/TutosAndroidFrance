package com.github.florent37.myyoutube.videolist;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.florent37.myyoutube.R;
import com.github.florent37.myyoutube.model.Video;
import com.github.florent37.myyoutube.task.SearchVideoTask;
import com.github.florent37.myyoutube.videodetail.DetailActivity;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import de.greenrobot.event.EventBus;


/**
 * Created by florentchampigny on 17/06/15.
 */
public class VideoListFragment extends Fragment implements SearchVideoTask.SearchVideoTaskCallBack, VideoAdapter.VideoAdapterCallBack {

    @InjectView(R.id.recyclerView)
    RecyclerView recyclerView;
    VideoAdapter videoAdapter;

    public static VideoListFragment newInstance() {
        VideoListFragment videoListFragment = new VideoListFragment();

        return videoListFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list_videos, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ButterKnife.inject(this, view);
        videoAdapter = new VideoAdapter(this);

        recyclerView.setAdapter(videoAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        search("Google IO");
    }

    private void search(String query){
        new SearchVideoTask(this).search(query);
    }

    @Override
    public void onPause() {
        super.onPause();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onVideoClicked(View view, Video video) {
        Bundle bundle = ActivityOptionsCompat.makeSceneTransitionAnimation(
                getActivity(),
                Pair.create(view.findViewById(R.id.image),getResources().getString(R.string.transitionImage)),
                Pair.create(view.findViewById(R.id.title),getResources().getString(R.string.transitionTitle))
        ).toBundle();

        Intent intent = new Intent(getActivity(), DetailActivity.class);
        intent.putExtra(DetailActivity.VIDEO, video);

        ActivityCompat.startActivity(getActivity(),intent,bundle);
    }

    //region SearchVideoTask

    @Override
    public void onSearchResult(List<Video> videoList) {
        videoAdapter.replace(videoList);
    }

    @Override
    public void onSearchFailure() {

    }

    //endregion

    //region event

    public void onEvent(SearchEvent event){
        this.search(event.getQuery());
    }

    public void onEventMainThread(RecyclerViewDisplaySwitchEvent event){
        boolean isGrid = this.videoAdapter.switchDisplayAsGrid();

        if(isGrid) {
            recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        }else{
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        }
    }

    //endregion
}
