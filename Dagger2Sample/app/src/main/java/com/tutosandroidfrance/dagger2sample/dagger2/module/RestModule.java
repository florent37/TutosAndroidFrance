package com.tutosandroidfrance.dagger2sample.dagger2.module;

import com.tutosandroidfrance.dagger2sample.BuildConfig;
import com.tutosandroidfrance.dagger2sample.storage.Storage;
import com.tutosandroidfrance.dagger2sample.webservice.GithubService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.android.AndroidLog;

/**
 * Ce module permet de récupérer le GithubService
 * Dagger2 va le crééer de façon unique (Singleton) et sera accéssible depuis le GithubComponent
 */
@Module
public class RestModule {

    /**
     * Créé le GithubService via Retrofit, qui réaliser les appels webservices,
     * en utilisant le StorageModule afin de gérer les clés
     *
     * @param storage le Storage injecté par Dagger2 via le StorageModule
     */
    @Singleton
    @Provides
    public GithubService provideGithubService(final Storage storage) {
        return new RestAdapter.Builder()
                .setEndpoint(BuildConfig.URL_GITHUB)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setLog(new AndroidLog("Retrofit"))
                .setRequestInterceptor(new RequestInterceptor() {
                    @Override
                    public void intercept(RequestFacade request) {
                        String key = storage.getApiKey();
                        if (key != null) {
                            //ajoute aux header la ApiKey en clé bearer
                            request.addHeader("bearer", key);
                        }
                    }
                })
                .build()
                .create(GithubService.class);
    }
}
