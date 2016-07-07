package com.jose.books.app.di.component;

import com.jose.books.app.di.module.DataSourceModule;
import com.jose.books.app.di.module.NavigatorModule;
import com.jose.books.app.navigator.Navigator;
import com.jose.books.data.book.BookDataSource;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by jose on 5/07/16.
 */
@Singleton
@Component(modules={NavigatorModule.class, DataSourceModule.class})
public interface ApplicationComponent {

    Navigator navigator();

    ApplicationComponent applicationComponent();

    BookDataSource bookDataSource();
}
