package com.jose.books.app.navigator;

import android.app.Activity;
import android.content.Intent;
import com.jose.books.ui.list.view.BookListActivity;
import com.jose.books.ui.list.view.BookListView;

/**
 * Created by jose on 5/07/16.
 */
public class DefaultNavigator implements Navigator {

    private Activity activity;

    @Override
    public void setActivity(Activity activity) {
      this.activity = activity;
    }

  @Override
  public void goToListView(String searchTerm) {
    Intent intent = new Intent(activity, BookListActivity.class);
    intent.putExtra(BookListView.SEARCH_TERM, searchTerm);
    activity.startActivity(intent);
  }
}
