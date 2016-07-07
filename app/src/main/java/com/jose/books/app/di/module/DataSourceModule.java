package com.jose.books.app.di.module;

import com.jose.books.data.book.BookDataSource;
import com.jose.books.data.book.retrofit.BookRetrofitSource;
import com.jose.books.data.book.retrofit.mapper.BookApiToModelMapper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jose on 7/07/16.
 */
@Module
public class DataSourceModule {

    @Provides
    @Singleton
    BookDataSource provideBookDataSource(BookApiToModelMapper mapper){
        return new BookRetrofitSource(mapper);
    }
}
