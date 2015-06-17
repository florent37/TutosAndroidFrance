package com.github.florent37.myyoutube.webservice;

import com.github.florent37.myyoutube.model.Video;
import com.github.florent37.myyoutube.model.YoutubeResponse;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by florentchampigny on 16/06/15.
 */
public interface YoutubeService {

    @GET("/search?type=video&part=snippet&maxResults=25")
    void searchVideos(@Query("q") String query, Callback<YoutubeResponse> youtubeResponse);

}
