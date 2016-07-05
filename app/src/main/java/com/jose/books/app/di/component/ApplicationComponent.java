package com.jose.books.app.di.component;

import com.jose.books.app.di.module.NavigatorModule;
import com.jose.books.app.navigator.Navigator;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by jose on 5/07/16.
 */
@Singleton
@Component(modules={NavigatorModule.class})
public interface ApplicationComponent {

    Navigator navigator();

    ApplicationComponent applicationComponent();
}
