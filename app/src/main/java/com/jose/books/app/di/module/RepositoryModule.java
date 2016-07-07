package com.jose.books.app.di.module;

import com.jose.books.data.book.BookDataSource;
import com.jose.books.domain.repository.BookRepository;
import com.jose.books.domain.repository.BookRepositoryImp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jose on 7/07/16.
 */
@Module
public class RepositoryModule {

    @Provides
    @Singleton
    BookRepository provideBookRepository(BookDataSource bookDataSource){
        return new BookRepositoryImp(bookDataSource);
    }
}
