package com.github.florent37.myyoutube.task;

import com.github.florent37.myyoutube.model.Video;
import com.github.florent37.myyoutube.model.YoutubeResponse;
import com.github.florent37.myyoutube.webservice.YoutubeApi;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by florentchampigny on 17/06/15.
 */
public class SearchVideoTask implements Callback<YoutubeResponse> {

    public interface SearchVideoTaskCallBack{
        void onSearchResult(List<Video> videoList);
        void onSearchFailure();
    }

    SearchVideoTaskCallBack callBack;

    public SearchVideoTask(SearchVideoTaskCallBack callBack) {
        this.callBack = callBack;
    }

    public void search(String query){
        YoutubeApi.getInstance().getYoutubeService()
                .searchVideos(query,this);
    }

    @Override
    public void success(YoutubeResponse youtubeResponse, Response response) {
        if(youtubeResponse == null || youtubeResponse.getItems() == null)
            callBack.onSearchFailure();
        else {
            this.callBack.onSearchResult(youtubeResponse.getItems());
        }
    }

    @Override
    public void failure(RetrofitError error) {

    }
}
