package com.tutosandroidfrance.dagger2sample;

import com.tutosandroidfrance.dagger2sample.dagger2.component.DaggerGithubComponent;
import com.tutosandroidfrance.dagger2sample.dagger2.component.GithubComponent;
import com.tutosandroidfrance.dagger2sample.dagger2.module.ContextModule;

/**
 * Created by florentchampigny on 03/06/15.
 */
public class Application extends android.app.Application {

    protected GithubComponent githubComponent;
    protected static Application application;

    @Override
    public void onCreate() {
        super.onCreate();

        application = this;

        //je créé mon githubcompoent, et le stock dans mon application
        githubComponent = DaggerGithubComponent.builder()
                .contextModule(new ContextModule(getApplicationContext()))
                .build();
    }

    public static Application app() {
        return application;
    }

    //permet aux activités via .getApplication().appComponent() de récupérer le AppComponent
    public GithubComponent component() {
        return githubComponent;
    }

}
