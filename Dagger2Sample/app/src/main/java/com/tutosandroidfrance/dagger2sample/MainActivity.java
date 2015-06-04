package com.tutosandroidfrance.dagger2sample;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.tutosandroidfrance.dagger2sample.dagger2.component.DaggerGithubComponent;
import com.tutosandroidfrance.dagger2sample.dagger2.component.GithubComponent;
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

        //Je demande à Dagger de me créer le GithubComponent
        GithubComponent githubComponent = DaggerGithubComponent.builder()
                .appComponent(((Application) getApplication()).appComponent())
                //.storageModule(new StorageModule())
                //.restModule(new RestModule())
                .build();
        //en lui indiquant d'utiliser comme appComponent celui créé dans mon Application

        //une fois le GithubComponent créer par Dagger2, nous pouvons récupérer le GithubService qu'il a créé
        GithubService githubService = githubComponent.githubService();

        //on peux maintenant utiliser notre webservice REST via Retrofit
        githubService.listRepos("florent37", new Callback<List<Repo>>() {
            @Override
            public void success(List<Repo> repos, Response response) {
                Toast.makeText(MainActivity.this,repos.size()+" repos",Toast.LENGTH_LONG).show();
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(MainActivity.this,error.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }

}
