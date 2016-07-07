package com.jose.books.app.di.module;

import com.jose.books.app.executor.InteractorExecutor;
import com.jose.books.app.executor.MainThreadExecutor;
import com.jose.books.domain.interactor.GetAllBooks;
import com.jose.books.domain.interactor.GetAllBooksImp;
import com.jose.books.domain.repository.BookRepository;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jose on 7/07/16.
 */
@Module
public class InteractorModule {

    @Provides
    GetAllBooks provideGetAllBooks(InteractorExecutor interactorExecutor,
                                   MainThreadExecutor mainThreadExecutor,
                                   BookRepository bookRepository){
        return new GetAllBooksImp(interactorExecutor, mainThreadExecutor, bookRepository);
    }
}
