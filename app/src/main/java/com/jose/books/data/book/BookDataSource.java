package com.jose.books.data.book;

import com.jose.books.domain.Book;

import java.util.List;

/**
 * Created by jose on 7/07/16.
 */
public interface BookDataSource {
    List<Book> getBooks();
}
