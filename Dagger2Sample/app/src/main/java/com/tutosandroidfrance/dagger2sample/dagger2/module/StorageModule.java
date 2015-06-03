package com.tutosandroidfrance.dagger2sample.dagger2.module;

import android.content.Context;
import android.content.SharedPreferences;

import com.tutosandroidfrance.dagger2sample.storage.Storage;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by florentchampigny on 03/06/15.
 */
@Module
public class StorageModule {

    @Provides
    @Singleton
    public Storage provideStorage(Context context){
        return new Storage(context);
    }

}
