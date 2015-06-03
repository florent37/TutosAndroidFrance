package com.tutosandroidfrance.dagger2sample.dagger2.component;

import android.content.Context;

import com.tutosandroidfrance.dagger2sample.dagger2.module.AppModule;

import dagger.Component;

@Component(modules = AppModule.class)
public interface AppComponent {
    Context context();
}
