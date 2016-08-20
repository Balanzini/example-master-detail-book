package com.jose.books.domain.interactor;

import com.jose.books.app.base.BaseInteractor;
import com.jose.books.app.executor.InteractorExecutor;
import com.jose.books.app.executor.MainThreadExecutor;
import com.jose.books.domain.model.Book;
import com.jose.books.domain.repository.BookRepository;

import java.io.IOException;
import java.util.List;

/**
 * Created by jose on 7/07/16.
 */
public class GetAllBooksImp extends BaseInteractor implements GetAllBooks {

  private Callback callback;
  private BookRepository bookRepository;
  private String key;

  public GetAllBooksImp(InteractorExecutor interactorExecutor,
      MainThreadExecutor mainThreadExecutor, BookRepository bookRepository) {
    super(interactorExecutor, mainThreadExecutor);
    this.bookRepository = bookRepository;
  }

  @Override
  public void getAllBooks(String key, Callback callback) {
    this.callback = callback;
    this.key = key;
    executeCurrentInteractor();
  }

  @Override
  public void run() {
    List<Book> bookList = null;
    try {
      bookList = bookRepository.getAllBooksByKey(key);
      endSuccess(bookList);
    } catch (IOException e) {
      e.printStackTrace();
      endError();
    }
  }

  private void endSuccess(final List<Book> finalBookList){
    executeInMainThread(new Runnable() {
      @Override
      public void run() {
        callback.onSuccess(finalBookList);
      }
    });
  }

  private void endError(){
    executeInMainThread(new Runnable() {
      @Override
      public void run() {
        callback.onError();
      }
    });
  }
}
