package com.jose.books.domain.repository;

import android.util.Log;
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

    public BookRepositoryImp(BookDataSource bookDataSource){
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
        bookMap.clear();
        for(Book book : bookDataSource.getBooks()){
            bookMap.put(book.getId(), book);
        }
        return getBookList();
    }

    @Override
    public List<Book> getAllBooksByAuthor(String author) throws IOException {
        bookMap.clear();
        for(Book book : bookDataSource.getBooksByAuthor(author)){
            bookMap.put(book.getId(), book);
            Log.i("BookRetrofitSource", "search id: " + book.getId());
        }
        return getBookList();
    }
}
