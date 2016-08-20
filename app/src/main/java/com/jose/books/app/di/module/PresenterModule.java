package com.jose.books.app.di.module;

import com.jose.books.app.navigator.Navigator;
import com.jose.books.domain.interactor.GetAllBooks;
import com.jose.books.domain.interactor.GetBookById;
import com.jose.books.ui.detail.presenter.DetailPresenter;
import com.jose.books.ui.detail.presenter.DetailPresenterImp;
import com.jose.books.ui.list.presenter.BookListPresenter;
import com.jose.books.ui.list.presenter.BookListPresenterImp;

import com.jose.books.ui.main.presenter.MainPresenter;
import com.jose.books.ui.main.presenter.MainPresenterImp;
import dagger.Module;
import dagger.Provides;

/**
 * Created by jose on 5/07/16.
 */
@Module
public class PresenterModule {

  @Provides
  BookListPresenter provideBookListPresenter(Navigator navigator, GetAllBooks getAllBooks) {
    return new BookListPresenterImp(navigator, getAllBooks);
  }

  @Provides
  MainPresenter provideMainPresenter(Navigator navigator) {
    return new MainPresenterImp(navigator);
  }

  @Provides
  DetailPresenter provideDetailPresenter(GetBookById getBookById){
    return new DetailPresenterImp(getBookById);
  }
}
