package com.tutosandroidfrance.dagger2sample.dagger2.module;

import android.content.Context;
import android.content.SharedPreferences;

import com.tutosandroidfrance.dagger2sample.storage.Storage;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Ce module permet à Dagger2 de créer un Storage
 * Dagger2 va le crééer de façon unique (Singleton) et sera accéssible depuis le GithubComponent
 */
@Module
public class StorageModule {

    /**
     * Retourne un Storage à Dagger2, construit avec le Context, injecté par Dagger2
     * @param context Contexte de l'application, fournit par Dagger2
     */
    @Provides
    @Singleton
    public Storage provideStorage(Context context){
        return new Storage(context);
    }

}
