package com.jose.books.data.book;

import com.jose.books.domain.model.Book;

import java.io.IOException;
import java.util.List;

/**
 * Created by jose on 7/07/16.
 */
public interface BookDataSource {
    List<Book> getBooks() throws IOException;

    List<Book> getBooksByAuthor(String author) throws IOException;
}
