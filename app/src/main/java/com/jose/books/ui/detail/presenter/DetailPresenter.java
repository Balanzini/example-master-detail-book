package com.jose.books.ui.detail.presenter;

import com.jose.books.app.base.BasePresenter;
import com.jose.books.ui.detail.view.DetailView;

/**
 * Created by jose on 20/08/16.
 */
public abstract class DetailPresenter extends BasePresenter<DetailView> {

  public abstract void searchBook(String bookId);
}
