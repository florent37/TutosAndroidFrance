package com.tutosandroidfrance.dagger2sample.dagger2.component;

import android.content.Context;

import com.tutosandroidfrance.dagger2sample.dagger2.module.AppModule;

import dagger.Component;

/**
 * Ce component sert à générer un context
 * Il utilise un AppModule en tant que Context Provider
 */

@Component(modules = AppModule.class)
public interface AppComponent {
    Context context();
}
