package com.jose.books.domain.interactor;

import com.jose.books.app.executor.Interactor;
import com.jose.books.domain.model.Book;

import java.util.List;

/**
 * Created by jose on 7/07/16.
 */
public interface GetAllBooks extends Interactor {

  void getAllBooks(String author, Callback callback);

  interface Callback {
    void onSuccess(List<Book> book);

    void onError();
  }
}
