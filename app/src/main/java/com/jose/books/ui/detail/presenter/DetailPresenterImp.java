package com.jose.books.ui.detail.presenter;

import com.jose.books.data.book.Constants;
import com.jose.books.domain.interactor.GetBookById;
import com.jose.books.domain.model.Book;

/**
 * Created by jose on 20/08/16.
 */
public class DetailPresenterImp extends DetailPresenter {

  private GetBookById getBookById;

  public DetailPresenterImp(GetBookById getBookById) {
    this.getBookById = getBookById;
  }

  @Override
  public void searchBook(String bookId) {
    getBookById.getBookById(bookId, new GetBookById.Callback() {
      @Override
      public void onSuccess(Book book) {
        view.setTitle(book.getTitle());
        view.setAuthor(book.getAuthor());
        view.setPublishYear(String.valueOf(book.getPublishYear()));

        if (book.getImageId().compareTo("0") == 0) {
          view.setErrorImage();
        } else {
          String imageUrl = Constants.BOOK_COVER_ID_PATH
              + book.getImageId()
              + Constants.BOOK_COVER_SIZE_M
              + Constants.BOOK_COVER_EXTENSION;
          view.setImage(imageUrl);
        }
      }

      @Override
      public void onError() {

      }
    });
  }
}
