package com.jose.books.app.di.module;

import com.jose.books.ui.list.presenter.BookListPresenter;
import com.jose.books.ui.list.presenter.BookListPresenterImp;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jose on 5/07/16.
 */
@Module
public class PresenterModule {

    @Provides
    BookListPresenter provideBookListPresenter(){
        return new BookListPresenterImp();
    }
}
