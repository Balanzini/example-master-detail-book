package com.jose.books.domain.interactor;

import android.util.Log;
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
  private String author;

  public GetAllBooksImp(InteractorExecutor interactorExecutor,
      MainThreadExecutor mainThreadExecutor, BookRepository bookRepository) {
    super(interactorExecutor, mainThreadExecutor);
    this.bookRepository = bookRepository;
  }

  @Override
  public void getAllBooks(String author, Callback callback) {
    this.callback = callback;
    this.author = author;
    executeCurrentInteractor();
  }

  @Override
  public void run() {
    List<Book> bookList = null;
    try {

      bookList = bookRepository.getAllBooksByAuthor(author);
      Log.i("BookRetrofitSource", "search term: " + bookList.size());

    } catch (IOException e) {
      e.printStackTrace();
      callback.onError();
    }
    final List<Book> finalBookList = bookList;
    executeInMainThread(new Runnable() {
      @Override
      public void run() {
        callback.onSuccess(finalBookList);
      }
    });
  }
}
