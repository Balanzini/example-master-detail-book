package com.jose.books.domain.interactor;

import com.jose.books.app.base.BaseInteractor;
import com.jose.books.app.executor.InteractorExecutor;
import com.jose.books.app.executor.MainThreadExecutor;
import com.jose.books.domain.model.Book;
import com.jose.books.domain.repository.BookRepository;

/**
 * Created by jose on 20/08/16.
 */
public class GetBookByIdImp extends BaseInteractor implements GetBookById {

  private BookRepository bookRepository;
  private String bookId;
  private Callback callback;

  public GetBookByIdImp(InteractorExecutor interactorExecutor,
      MainThreadExecutor mainThreadExecutor, BookRepository bookRepository) {
    super(interactorExecutor, mainThreadExecutor);
    this.bookRepository = bookRepository;
  }

  @Override
  public void getBookById(String id, Callback callback) {
    this.bookId = id;
    this.callback = callback;
    executeCurrentInteractor();
  }

  @Override
  public void run() {
    Book bookResult = bookRepository.getBookById(bookId);
    if(bookResult != null) {
      callback.onSuccess(bookResult);
    }
    else{
      callback.onError();
    }
  }
}
