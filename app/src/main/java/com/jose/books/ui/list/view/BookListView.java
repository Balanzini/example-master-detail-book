package com.jose.books.ui.list.view;

import com.jose.books.domain.model.Book;
import com.jose.books.ui.View;

import java.util.List;

/**
 * Created by jose on 5/07/16.
 */
public interface BookListView extends View {

    void onBookAvailable(List<Book> bookList);
}
