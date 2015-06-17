package com.github.florent37.myyoutube.webservice;

import com.github.florent37.myyoutube.BuildConfig;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.android.AndroidLog;

/**
 * Created by florentchampigny on 16/06/15.
 */
public class YoutubeApi {

    private static YoutubeApi INSTANCE;

    private YoutubeService youtubeService;

    private YoutubeApi(){
        youtubeService = new RestAdapter.Builder()
                .setEndpoint(BuildConfig.YOUTUBE_API_URL)
                .setLog(new AndroidLog("Retrofit"))
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setRequestInterceptor(new RequestInterceptor() {
                    @Override
                    public void intercept(RequestFacade request) {
                        request.addQueryParam("key", BuildConfig.YOUTUBE_KEY);
                    }
                })
                .build()
                .create(YoutubeService.class);
    }



    public static YoutubeApi getInstance(){
        if(INSTANCE == null){
            INSTANCE = new YoutubeApi();
        }
        return INSTANCE;
    }

    public YoutubeService getYoutubeService() {
        return youtubeService;
    }
}
