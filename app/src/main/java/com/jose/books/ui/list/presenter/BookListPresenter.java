package com.jose.books.ui.list.presenter;

import com.jose.books.app.base.BasePresenter;
import com.jose.books.ui.list.view.BookListView;

/**
 * Created by jose on 5/07/16.
 */
public abstract class BookListPresenter extends BasePresenter<BookListView> {

    public abstract void getBooks();
}
