package com.tutosandroidfrance.dagger2sample.dagger2.component;

import com.tutosandroidfrance.dagger2sample.dagger2.module.RestModule;
import com.tutosandroidfrance.dagger2sample.dagger2.module.StorageModule;
import com.tutosandroidfrance.dagger2sample.webservice.GithubService;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by florentchampigny on 03/06/15.
 */
@Singleton
@Component(dependencies = {AppComponent.class}, modules = {StorageModule.class, RestModule.class})
public interface GithubComponent {
    GithubService githubService();
}
