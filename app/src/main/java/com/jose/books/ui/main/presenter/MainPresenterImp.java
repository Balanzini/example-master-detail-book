package com.jose.books.ui.main.presenter;

import com.jose.books.app.navigator.Navigator;

/**
 * Created by jose on 19/07/16.
 */
public class MainPresenterImp extends MainPresenter {

  private Navigator navigator;

  public MainPresenterImp(Navigator navigator){
    this.navigator = navigator;
  }

  @Override
  public void onSearchSelected(String searchTerm) {
    String search = changeSpaces(searchTerm);
    navigator.goToListView(search);
  }

  private String changeSpaces(String term){
    return term.replace(' ', '+');
  }
}
