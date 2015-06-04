package com.tutosandroidfrance.dagger2sample.webservice;

import com.tutosandroidfrance.dagger2sample.model.Repo;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

public interface GithubService {

    @GET("/users/{user}/repos")
    void listRepos(@Path("user") String user, Callback<List<Repo>> callback);

}
