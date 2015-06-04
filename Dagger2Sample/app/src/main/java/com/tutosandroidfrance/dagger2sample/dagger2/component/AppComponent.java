package com.tutosandroidfrance.dagger2sample.dagger2.component;

import android.content.Context;

import com.tutosandroidfrance.dagger2sample.dagger2.module.AppModule;

import dagger.Component;

/**
 * Ce Component permet à Dagger2 de générer un context
 * Il utilise un AppModule en tant que Context Provider
 * AppModule aura son context injecté lors de la création de l'application
 */
@Component(modules = AppModule.class)
public interface AppComponent {

    //AppComponent à la capacité de générer un context, et de le renre accessible via .context()
    Context context();
}
