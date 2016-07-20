package com.jose.books.data.book.retrofit.mapper;

import android.util.Log;
import com.jose.books.app.exception.NoAuthorException;
import com.jose.books.data.book.retrofit.model.OLBook;
import com.jose.books.data.book.retrofit.model.OLBookList;
import com.jose.books.domain.model.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jose on 7/07/16.
 */
public class BookApiToModelMapperImp implements BookApiToModelMapper {

  private static final String TAG = "BookApiToModelMapper";

  @Override
  public List<Book> mapBookListResponseToModel(OLBookList responseBookList) {
    List<Book> bookList = new ArrayList<Book>();
    for (OLBook olBook : responseBookList.getOlBookList()) {
      bookList.add(mapBookResponseToModel(olBook));
    }
    return bookList;
  }

  private Book mapBookResponseToModel(OLBook responseBook) {

    String author;
    try {
      author = responseBook.getAuthor_name()[0];
    } catch (NoAuthorException e) {
      Log.e(TAG, e.getMessage());
      author = "";
    }
    int publishYear = responseBook.getPublish_year();
    String imageId = String.valueOf(responseBook.getCover_i());

    Book book = new Book(responseBook.getKey(), responseBook.getTitle(), author, imageId);
    book.setPublishYear(publishYear);
    return book;
  }
}
