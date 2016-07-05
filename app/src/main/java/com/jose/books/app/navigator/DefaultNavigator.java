package com.jose.books.app.navigator;

import com.jose.books.app.base.BaseActivity;

/**
 * Created by jose on 5/07/16.
 */
public class DefaultNavigator implements Navigator {

    private BaseActivity activity;

    @Override
    public void setActivity(BaseActivity activity) {
      this.activity = activity;
    }
}
