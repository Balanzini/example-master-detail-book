package com.jose.books.ui.detail.view;

import android.os.Bundle;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.jose.books.R;
import com.jose.books.app.base.BaseActivity;
import com.jose.books.ui.detail.presenter.DetailPresenter;
import javax.inject.Inject;

/**
 * Created by jose on 20/08/16.
 */
public class DetailActivity extends BaseActivity implements DetailView {

  @Inject DetailPresenter presenter;

  @Bind(R.id.tv_detail_title) TextView tvTitle;

  private String bookId;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.detail_layout);
    ButterKnife.bind(this);
    bookId = getIntent().getExtras().getString(BOOK_ID);

  }

  @Override
  protected void onResume() {
    super.onResume();
    presenter.setView(this);
    presenter.searchBook(bookId);
  }


  @Override
  protected void doInjection() {
    component.inject(this);
  }
}
