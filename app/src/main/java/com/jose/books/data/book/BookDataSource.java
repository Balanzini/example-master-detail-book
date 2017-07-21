package com.jose.books.data.book;

import com.jose.books.domain.model.Book;

import java.io.IOException;
import java.util.List;

/**
 * Created by jose on 7/07/16.
 */
public interface BookDataSource {
    List<Book> getBooks();

    List<Book> getBooksByAuthor(String author) throws IOException;

    List<Book> getBooksByKey(String key) throws IOException;
}
