package com.jose.books.app.di.component;

import com.jose.books.app.base.BaseApplication;
import com.jose.books.app.di.module.DataSourceModule;
import com.jose.books.app.di.module.ExecutorModule;
import com.jose.books.app.di.module.MapperModule;
import com.jose.books.app.di.module.NavigatorModule;
import com.jose.books.app.di.module.RepositoryModule;
import com.jose.books.app.executor.InteractorExecutor;
import com.jose.books.app.executor.MainThreadExecutor;
import com.jose.books.app.navigator.Navigator;
import com.jose.books.data.book.BookDataSource;
import com.jose.books.data.book.retrofit.mapper.BookApiToModelMapper;
import com.jose.books.domain.repository.BookRepository;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by jose on 5/07/16.
 */
@Singleton
@Component(modules={NavigatorModule.class, DataSourceModule.class, MapperModule.class,
        RepositoryModule.class, ExecutorModule.class})
public interface ApplicationComponent {

    Navigator navigator();

    ApplicationComponent applicationComponent();

    BookDataSource bookDataSource();

    BookApiToModelMapper bookMapper();

    BookRepository bookRepository();

    InteractorExecutor interactorExecutor();

    MainThreadExecutor mainThreadExecutor();

    void inject(BaseApplication baseApplication);
}
