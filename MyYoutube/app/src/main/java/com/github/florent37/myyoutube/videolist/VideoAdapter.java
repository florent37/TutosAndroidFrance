package com.github.florent37.myyoutube.videolist;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.florent37.myyoutube.R;
import com.github.florent37.myyoutube.model.Video;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by florentchampigny on 17/06/15.
 */
public class VideoAdapter extends RecyclerView.Adapter<VideoViewHolder> {

    public interface VideoAdapterCallBack{
        void onVideoClicked(View view, Video video);
    }

    List<Video> videoList;
    VideoAdapterCallBack videoAdapterCallBack;
    boolean displayAsGrid = false;

    public VideoAdapter(VideoAdapterCallBack videoAdapterCallBack) {
        this.videoList = new ArrayList<>();
        this.videoAdapterCallBack = videoAdapterCallBack;
    }

    public void addAll(List<Video> videos){
        this.videoList.addAll(videos);
        this.notifyDataSetChanged();
    }

    public void replace(List<Video> videos){
        this.clear();
        this.addAll(videos);
    }

    public void clear(){
        this.videoList.clear();
        this.notifyDataSetChanged();
    }

    @Override
    public VideoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layoutId = displayAsGrid ? R.layout.cell_video_grid : R.layout.cell_video;
        View view = LayoutInflater.from(parent.getContext()).inflate(layoutId,parent,false);
        return new VideoViewHolder(view,this.videoAdapterCallBack);
    }

    @Override
    public void onBindViewHolder(VideoViewHolder holder, int position) {
        holder.bind(videoList.get(position));
    }

    public boolean switchDisplayAsGrid() {
        this.displayAsGrid = !displayAsGrid;
        notifyDataSetChanged();

        return displayAsGrid;
    }

    @Override
    public int getItemCount() {
        return videoList.size();
    }
}
