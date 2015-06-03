package com.tutosandroidfrance.dagger2sample.webservice;

import com.tutosandroidfrance.dagger2sample.model.Repo;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by florentchampigny on 03/06/15.
 */
public interface GithubService {

    @GET("/search/repositories")
    void searchRepos(@Query("q") String query, Callback<List<Repo>> callback);

}
