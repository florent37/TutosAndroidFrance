package com.tutosandroidfrance.RetrofitSample;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.Path;
import retrofit.http.Query;
import rx.Observable;

public interface GithubService {

    String ENDPOINT = "https://api.github.com";

    @GET("/users/{user}/repos")
    Observable<List<Repo>> listRepos(@Path("user") String user);

    @GET("/search/repositories")
    Observable<List<Repo>> searchRepos(@Query("q") String query);
}
