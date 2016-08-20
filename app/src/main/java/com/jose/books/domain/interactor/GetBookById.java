package com.jose.books.domain.interactor;

import com.jose.books.app.executor.Interactor;
import com.jose.books.domain.model.Book;

/**
 * Created by jose on 20/08/16.
 */
public interface GetBookById extends Interactor {

  void getBookById(String id, Callback callback);

  interface Callback {
    void onSuccess(Book book);

    void onError();
  }
}
