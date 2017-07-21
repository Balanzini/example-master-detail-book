package com.jose.books.ui.detail.view;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.jose.books.R;
import com.jose.books.app.base.BaseActivity;
import com.jose.books.ui.detail.presenter.DetailPresenter;
import javax.inject.Inject;

/**
 * Created by jose on 20/08/16.
 */
public class DetailActivity extends BaseActivity implements DetailView {

  @Inject DetailPresenter presenter;

  @Bind(R.id.iv_detail_cover) ImageView ivCover;
  @Bind(R.id.tv_detail_title) TextView tvTitle;
  @Bind(R.id.tv_detail_publisher) TextView tvPublisher;
  @Bind(R.id.tv_detail_author) TextView tvAuthor;
  @Bind(R.id.tv_detail_publish_year) TextView tvPublishYear;

  //private String bookId;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.detail_layout);
    ButterKnife.bind(this);
    //bookId = getIntent().getExtras().getString(BOOK_ID);
    Glide.with(this)
        .load(
            "https://upload.wikimedia.org/wikipedia/commons/thumb/d/db/Android_robot_2014.svg/100px-Android_robot_2014.svg.png")
        .centerCrop()
        .into(ivCover);
  }

  @Override
  protected void onResume() {
    super.onResume();
    //presenter.setView(this);
    //presenter.searchBook(bookId);
  }

  @Override
  public void setImage(String urlImage) {
    Glide.with(getApplicationContext())
        .load(urlImage)
        .placeholder(R.drawable.search)
        .error(R.drawable.error)
        .into(ivCover);
  }

  @Override
  public void setErrorImage() {
    Glide.with(this)
        .load(
            "https://upload.wikimedia.org/wikipedia/commons/thumb/d/db/Android_robot_2014.svg/100px-Android_robot_2014.svg.png")
        .centerCrop()
        .into(ivCover);
  }

  @Override
  public void setTitle(String title) {
    tvTitle.setText(title);
  }

  @Override
  public void setAuthor(String author) {
    tvAuthor.setText(author);
  }

  @Override
  public void setPublisher(String publisher) {
    tvPublisher.setText(publisher);
  }

  @Override
  public void setPublishYear(String publishYear) {
    tvPublishYear.setText(publishYear);
  }

  @Override
  protected void doInjection() {
    component.inject(this);
  }
}
