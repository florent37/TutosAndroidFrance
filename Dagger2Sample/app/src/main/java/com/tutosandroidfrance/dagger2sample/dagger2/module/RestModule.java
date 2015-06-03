package com.tutosandroidfrance.dagger2sample.dagger2.module;

import com.tutosandroidfrance.dagger2sample.BuildConfig;
import com.tutosandroidfrance.dagger2sample.storage.Storage;
import com.tutosandroidfrance.dagger2sample.webservice.GithubService;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;

/**
 * Created by florentchampigny on 03/06/15.
 */
@Module
public class RestModule {

    @Singleton
    @Provides
    public GithubService provideGithubService(final Storage storage){
        return new RestAdapter.Builder()
                .setEndpoint(BuildConfig.URL_GITHUB)
                .setRequestInterceptor(new RequestInterceptor() {
                    @Override
                    public void intercept(RequestFacade request) {
                        request.addHeader("bearer", storage.getApiKey());
                    }
                })
                .build()
                .create(GithubService.class);
    }
}
