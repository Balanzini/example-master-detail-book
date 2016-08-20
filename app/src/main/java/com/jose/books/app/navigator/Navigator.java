package com.jose.books.app.navigator;

import android.app.Activity;

/**
 * Created by jose on 5/07/16.
 */
public interface Navigator {

    void setActivity(Activity activity);

    void goToListView(String searchTerm);

    void goToDetailView(String bookId);
}
