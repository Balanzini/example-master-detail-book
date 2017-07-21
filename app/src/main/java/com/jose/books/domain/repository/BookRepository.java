package com.jose.books.domain.repository;

import com.jose.books.domain.model.Book;

import java.io.IOException;
import java.util.List;

/**
 * Created by jose on 7/07/16.
 */
public interface BookRepository {

    Book getBookById(String id);

    List<Book> getBookList();

    List<Book> getAllBooks();

    List<Book> getAllBooksByAuthor(String author);

    List<Book> getAllBooksByKey(String key) throws IOException;

}
