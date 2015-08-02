package com.tutosandroidfrance.dagger2sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.tutosandroidfrance.dagger2sample.dagger2.component.DaggerGithubComponent;
import com.tutosandroidfrance.dagger2sample.dagger2.component.GithubComponent;
import com.tutosandroidfrance.dagger2sample.model.Repo;
import com.tutosandroidfrance.dagger2sample.webservice.GithubService;

import java.util.List;

import javax.inject.Inject;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    @Inject
    GithubService githubService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //je demande à mon GithubComponent d'injecter les dépendances dans cette activity
        Application.app().component().inject(this);

        //une fois le GithubComponent créer par Dagger2, nous pouvons récupérer le GithubService qu'il a créé
        // GithubService githubService = githubComponent.githubService();

        //on peux maintenant utiliser notre webservice REST via Retrofit
        githubService.listRepos("florent37", new Callback<List<Repo>>() {
            @Override
            public void success(List<Repo> repos, Response response) {
                Toast.makeText(MainActivity.this, repos.size() + " repos", Toast.LENGTH_LONG).show();
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

}
