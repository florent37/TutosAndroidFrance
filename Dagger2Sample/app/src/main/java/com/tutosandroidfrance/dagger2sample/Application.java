package com.tutosandroidfrance.dagger2sample;

import android.content.Context;

import com.tutosandroidfrance.dagger2sample.dagger2.component.AppComponent;
import com.tutosandroidfrance.dagger2sample.dagger2.component.DaggerAppComponent;
import com.tutosandroidfrance.dagger2sample.dagger2.module.AppModule;

/**
 * Created by florentchampigny on 03/06/15.
 */
public class Application extends android.app.Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        //provides the application context
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent appComponent() {
        return appComponent;
    }

}
