package com.jose.books.domain.repository;

import com.jose.books.data.book.BookDataSource;
import com.jose.books.domain.model.Book;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jose on 7/07/16.
 */
public class BookRepositoryImp implements BookRepository {

  private BookDataSource bookDataSource;
  private Map<String, Book> bookMap;

  public BookRepositoryImp(BookDataSource bookDataSource) {
    this.bookDataSource = bookDataSource;
    bookMap = new HashMap<String, Book>();
  }

  @Override
  public Book getBookById(String id) {
    return bookMap.get(id);
  }

  @Override
  public List<Book> getBookList() {
    List<Book> bookList = new ArrayList<Book>(bookMap.values());
    return bookList;
  }

  @Override
  public List<Book> getAllBooks() throws IOException {
    setBookMap(bookDataSource.getBooks());
    return getBookList();
  }

  @Override
  public List<Book> getAllBooksByAuthor(String author) throws IOException {
    setBookMap(bookDataSource.getBooksByAuthor(author));
    return getBookList();
  }

  @Override
  public List<Book> getAllBooksByKey(String key) throws IOException {
    setBookMap(bookDataSource.getBooksByKey(key));
    return getBookList();
  }

  private void setBookMap(List<Book> bookList){
    bookMap.clear();
    for (Book book : bookList) {
      bookMap.put(book.getId(), book);
    }
  }
}
