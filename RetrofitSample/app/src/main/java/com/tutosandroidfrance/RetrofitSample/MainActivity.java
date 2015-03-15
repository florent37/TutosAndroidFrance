package com.tutosandroidfrance.RetrofitSample;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.Toast;

import java.util.List;

import retrofit.Callback;
import retrofit.ErrorHandler;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.android.AndroidLog;
import retrofit.client.Response;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //appelSynchrone();
        appelAsynchrone();
    }

    private void appelSynchrone() {
        new ListReposTask().execute("florent37");
    }

    private void appelAsynchrone() {
        GithubService githubService = new RestAdapter.Builder()
                .setEndpoint(GithubService.ENDPOINT)
                .setLog(new AndroidLog("retrofit"))
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build()
                .create(GithubService.class);

        githubService.listReposAsync("florent37", new Callback<List<Repo>>() {
            @Override
            public void success(List<Repo> repos, Response response) {
                afficherRepos(repos);
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    public void afficherRepos(List<Repo> repos) {
        Toast.makeText(this, "nombre de dépots : " + repos.size(), Toast.LENGTH_SHORT).show();
    }

    public void notAllowed() {
        Toast.makeText(this, "Impossible d'effectuer cette action", Toast.LENGTH_SHORT).show();
    }

    class ListReposTask extends AsyncTask<String, Void, List<Repo>> {

        @Override
        protected List<Repo> doInBackground(String... params) {
            GithubService githubService = new RestAdapter.Builder()
                    .setEndpoint(GithubService.ENDPOINT)
                    .setErrorHandler(new ErrorHandler() {
                        @Override
                        public Throwable handleError(RetrofitError cause) {
                            Response r = cause.getResponse();
                            if (r != null && r.getStatus() == 405) {
                                MainActivity.this.notAllowed();
                            }
                            return cause;
                        }
                    })
                    .setRequestInterceptor(
                            new RequestInterceptor() {
                                @Override
                                public void intercept(RequestFacade request) {
                                    //ajoute "baerer: 1234567890" en header de chaque requête
                                    request.addHeader("bearer", "1234567890");
                                }
                            }
                    ).build().create(GithubService.class);

            String user = params[0];
            List<Repo> repoList = githubService.listRepos(user);

            return repoList;
        }

        @Override
        protected void onPostExecute(List<Repo> repos) {
            super.onPostExecute(repos);
            afficherRepos(repos);
        }
    }

    class MyErrorHandler implements
}

}
