package com.jose.books.ui.main.presenter;

import com.jose.books.app.base.BasePresenter;
import com.jose.books.ui.main.view.MainView;

/**
 * Created by jose on 19/07/16.
 */
public abstract class MainPresenter extends BasePresenter<MainView> {
  public abstract void onSearchSelected(String searchTerm);
}
