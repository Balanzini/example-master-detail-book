package com.jose.books.app.di.module;

import com.jose.books.app.navigator.DefaultNavigator;
import com.jose.books.app.navigator.Navigator;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jose on 5/07/16.
 */
@Module
public class NavigatorModule {

    @Provides
    @Singleton
    Navigator provideNavigator(){
        return new DefaultNavigator();
    }
}
