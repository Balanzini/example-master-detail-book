package com.jose.books.ui.list.view;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.jose.books.R;
import com.jose.books.app.base.BaseActivity;
import com.jose.books.domain.model.Book;
import com.jose.books.ui.list.adapter.BookAdapter;
import com.jose.books.ui.list.presenter.BookListPresenter;

import java.util.List;

import javax.inject.Inject;

public class BookListActivity extends BaseActivity implements BookListView {

  private static final String TAG = "BookListActivity";

  @Inject BookListPresenter presenter;

  @Bind(R.id.rv_book_list) RecyclerView recyclerViewBook;
  @Bind(R.id.ll_searching_view) LinearLayout llSearching;
  @Bind(R.id.tv_loading) TextView tvLoading;

  private BookAdapter adapter;
  private String searchTerm;
  private Animation pulseAnimation;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.book_list_layout);
    ButterKnife.bind(this);
    searchTerm = getIntent().getExtras().getString(SEARCH_TERM);
    pulseAnimation = AnimationUtils.loadAnimation(this, R.anim.pulse_anim);
  }

  @Override
  protected void onResume() {
    super.onResume();
    presenter.setView(this);
    adapter = new BookAdapter();
    adapter.setOnClick(new BookAdapter.OnClick() {
      @Override
      public void onBookClicked(String bookId) {
        presenter.onItemClick(bookId);
      }
    });
    recyclerViewBook.setAdapter(adapter);

    presenter.getBooks(searchTerm);
    tvLoading.setAnimation(pulseAnimation);
  }

  @Override
  public void onBookAvailable(List<Book> bookList) {
    llSearching.setVisibility(View.GONE);
    adapter.setBookList(bookList);
  }

  @Override
  protected void doInjection() {
    component.inject(this);
  }
}
