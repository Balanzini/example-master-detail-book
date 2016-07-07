package com.jose.books.ui.list.view;

import android.os.Bundle;
import com.jose.books.R;
import com.jose.books.app.base.BaseActivity;
import com.jose.books.ui.list.presenter.BookListPresenter;

import javax.inject.Inject;

public class BookListActivity extends BaseActivity implements BookListView  {

    private static final String TAG = "BookListActivity";
    @Inject
    BookListPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter.prueba();
    }

    @Override
    protected void doInjection() {
        component.inject(this);
    }
}
