package com.jose.books.ui.list.presenter;

import android.util.Log;

import com.jose.books.app.navigator.Navigator;
import com.jose.books.domain.interactor.GetAllBooks;
import com.jose.books.domain.model.Book;

import java.util.List;

/**
 * Created by jose on 5/07/16.
 */
public class BookListPresenterImp extends BookListPresenter {

  private static final String TAG = "BookListPresenter";

  private Navigator navigator;
  private GetAllBooks getAllBooks;

  public BookListPresenterImp(Navigator navigator, GetAllBooks getAllBooks) {
    this.navigator = navigator;
    this.getAllBooks = getAllBooks;
  }

  @Override
  public void getBooks(String author) {
    getAllBooks.getAllBooks(author, new GetAllBooks.Callback() {
      @Override
      public void onSuccess(List<Book> book) {
        Log.i(TAG, book.size() + "");

        for (Book b : book) {
          Log.i(TAG, b.getTitle());
        }
        view.onBookAvailable(book);
      }

      @Override
      public void onError() {
        Log.e(TAG, "error");
      }
    });
  }

  @Override
  public void onItemClick(String idBook) {
    navigator.goToDetailView(idBook);
  }
}
