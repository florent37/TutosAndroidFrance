package com.github.florent37.myyoutube.videolist;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.florent37.myyoutube.R;
import com.github.florent37.myyoutube.model.Video;
import com.squareup.picasso.Picasso;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by florentchampigny on 17/06/15.
 */
public class VideoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    @InjectView(R.id.image) ImageView imageView;
    @InjectView(R.id.title) TextView title;
    @InjectView(R.id.subTitle) TextView subTitle;

    VideoAdapter.VideoAdapterCallBack videoAdapterCallBack;

    Video video;

    public VideoViewHolder(View itemView, VideoAdapter.VideoAdapterCallBack videoAdapterCallBack) {
        super(itemView);
        this.videoAdapterCallBack = videoAdapterCallBack;

        ButterKnife.inject(this,itemView);
        itemView.setOnClickListener(this);
    }

    public void bind(Video video){
        this.video = video;

        title.setText(video.getSnippet().getTitle());
        subTitle.setText(video.getSnippet().getChannelTitle());

        Picasso.with(imageView.getContext())
                .load(video.getSnippet().getThumbnails().getMedium().getUrl())
                .fit().centerCrop()
                .into(imageView);
    }

    @Override
    public void onClick(View v) {
        if(videoAdapterCallBack != null){
            videoAdapterCallBack.onVideoClicked(v,video);
        }
    }
}
