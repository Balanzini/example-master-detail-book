package com.jose.books.interactor;

import android.os.Handler;
import android.os.Looper;
import com.jose.books.app.executor.InteractorExecutorImp;
import com.jose.books.app.executor.MainThreadExecutor;
import com.jose.books.domain.interactor.GetAllBooks;
import com.jose.books.domain.interactor.GetAllBooksImp;
import com.jose.books.domain.model.Book;
import com.jose.books.domain.repository.BookRepository;
import java.util.List;
import org.junit.Test;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by jose on 9/02/17.
 */
public class GetBooksTest {

  @Test
  public void getComicInteractorShouldCallTheCallbackOnSuccess() {

    List<Book> mockedList = (List<Book>) mock(List.class);

    BookRepository mockedBookRepository = mock(BookRepository.class);
    when(mockedBookRepository.getAllBooksByAuthor("Agapito")).thenReturn(mockedList);

    GetAllBooks.Callback mockedCallback = mock(GetAllBooks.Callback.class);

    GetAllBooks getBooksInteractor =
        new GetAllBooksImp(new InteractorExecutorImp(), new StubMainThreadExecutor(),
            mockedBookRepository);
    getBooksInteractor.getAllBooks("Agapito", mockedCallback);

    verify(mockedCallback).onSuccess(anyList());
  }

  private class StubMainThreadExecutor implements MainThreadExecutor {

    @Override
    public void execute(Runnable runnable) {
      runnable.run();
    }
  }
}
