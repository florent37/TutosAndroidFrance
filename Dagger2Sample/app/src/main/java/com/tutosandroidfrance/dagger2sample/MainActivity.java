package com.tutosandroidfrance.dagger2sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.tutosandroidfrance.dagger2sample.dagger2.component.DaggerGithubComponent;
import com.tutosandroidfrance.dagger2sample.dagger2.module.RestModule;
import com.tutosandroidfrance.dagger2sample.dagger2.module.StorageModule;
import com.tutosandroidfrance.dagger2sample.model.Repo;
import com.tutosandroidfrance.dagger2sample.webservice.GithubService;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GithubService githubService = DaggerGithubComponent.builder()
                .appComponent(((Application) getApplication()).appComponent())
                .storageModule(new StorageModule())
                .restModule(new RestModule())
                .build()
                .githubService();

        githubService.searchRepos("Florent37", new Callback<List<Repo>>() {
            @Override
            public void success(List<Repo> repos, Response response) {
                Log.d("tag", repos.toString());
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d("tag", error.getMessage());
            }
        });
    }

}
