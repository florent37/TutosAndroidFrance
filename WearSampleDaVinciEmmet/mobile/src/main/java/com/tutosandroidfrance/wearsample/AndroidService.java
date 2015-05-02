package com.tutosandroidfrance.wearsample;

import com.tutosandroidfrance.wearprotocol.AndroidVersion;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

public interface AndroidService {

    public static final String ENDPOINT = "http://pastebin.com";

    @GET("/raw.php?i=PHPXBsEf")
    public void getElements(Callback<List<AndroidVersion>> callback);
}
