package com.jose.books.app.base;

import android.app.Activity;
import android.app.Application;

import android.os.Bundle;
import com.jose.books.app.di.component.ApplicationComponent;
import com.jose.books.app.di.component.DaggerApplicationComponent;
import com.jose.books.app.di.module.NavigatorModule;
import com.jose.books.app.navigator.Navigator;

import javax.inject.Inject;

/**
 * Created by jose on 5/07/16.
 */
public class BaseApplication extends Application implements Application.ActivityLifecycleCallbacks {

    @Inject
    Navigator navigator;

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        registerActivityLifecycleCallbacks(this);

        applicationComponent = DaggerApplicationComponent.builder()
                // list of modules that are part of this component need to be created here too
                .navigatorModule(new NavigatorModule()) // This also corresponds to the name of your module: %component_name%Module
                .build();

        applicationComponent.inject(this);

        // If a Dagger 2 component does not have any constructor arguments for any of its modules,
        // then we can use .create() as a shortcut instead:
        //  mAppComponent = com.codepath.dagger.components.DaggerNetComponent.create();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle bundle) {

    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {
        navigator.setActivity(activity);
    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

    }
}
