package com.tutosandroidfrance.dagger2sample.dagger2.component;

import com.tutosandroidfrance.dagger2sample.dagger2.module.RestModule;
import com.tutosandroidfrance.dagger2sample.dagger2.module.StorageModule;
import com.tutosandroidfrance.dagger2sample.storage.Storage;
import com.tutosandroidfrance.dagger2sample.webservice.GithubService;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Composant principale de ce tutoriel, GithubComponent va utiliser Dagger2 afin de créer le GithubService et le Storage
 * Ce composant est un singleton, c'est à dire qu'il n'existe qu'un fois lors de l'éxécution de l'application
 *
 * dependencies = {AppComponent.class} indique que ce Component dépend de AppComponent afin
 * qu'il lui @Provide un objet, dans notre cas, le Context
 *
 * modules = {StorageModule.class, RestModule.class} indique que ce Component utilisera
 * les fonctions indiquées en @Provide de StorageModule et RestModule afin de générer les GithubService et Storage
 */
@Singleton
@Component(dependencies = {AppComponent.class}, modules = {StorageModule.class, RestModule.class})
public interface GithubComponent {
    GithubService githubService();
    Storage storage();
}
