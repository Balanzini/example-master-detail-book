package com.jose.books.ui.list.view;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import com.jose.books.R;
import com.jose.books.app.base.BaseActivity;
import com.jose.books.domain.model.Book;
import com.jose.books.ui.list.adapter.BookAdapter;
import com.jose.books.ui.list.presenter.BookListPresenter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BookListActivity extends BaseActivity implements BookListView  {

    private static final String TAG = "BookListActivity";

    @Inject
    BookListPresenter presenter;

    @BindView(R.id.rv_book_list)
    RecyclerView recyclerViewBook;

    private BookAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.setView(this);
        adapter = new BookAdapter();
        recyclerViewBook.setAdapter(adapter);
        presenter.getBooks();
    }

    @Override
    public void onBookAvailable(List<Book> bookList) {
        adapter.setBookList(bookList);
    }

    @Override
    protected void doInjection() {
        component.inject(this);

    }
}
