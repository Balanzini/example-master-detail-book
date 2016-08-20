package com.jose.books.ui.detail.presenter;

import com.jose.books.domain.interactor.GetBookById;
import com.jose.books.domain.model.Book;

/**
 * Created by jose on 20/08/16.
 */
public class DetailPresenterImp extends DetailPresenter {

  private GetBookById getBookById;

  public DetailPresenterImp(GetBookById getBookById){
      this.getBookById = getBookById;
  }

  @Override
  public void searchBook(String bookId) {
    getBookById.getBookById(bookId, new GetBookById.Callback() {
      @Override
      public void onSuccess(Book book) {

      }

      @Override
      public void onError() {

      }
    });
  }
}
