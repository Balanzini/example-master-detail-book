package com.jose.books.ui.list.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.Bind;
import com.bumptech.glide.Glide;
import com.jose.books.R;
import com.jose.books.data.book.retrofit.RetrofitConstants;
import com.jose.books.domain.model.Book;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by jose on 12/07/16.
 */
public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {

  public static final String TAG = "BookAdapter";
  public static final String BOOK_COVER_ID_PATH = "b/id/";
  public static final String BOOK_COVER_SIZE = "-M";
  public static final String BOOK_COVER_EXTENSION = ".jpg";

  private List<Book> bookList;
  private Context context;

  public BookAdapter() {
    bookList = new ArrayList<>();
  }

  @Override
  public BookViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    context = parent.getContext();
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
    return new BookViewHolder(view);
  }

  @Override
  public void onBindViewHolder(BookViewHolder holder, int position) {
    setBookHolder(bookList.get(position), holder);
  }

  @Override
  public int getItemCount() {
    return bookList.size();
  }

  private void setBookHolder(Book bookInstance, BookViewHolder holder) {
    holder.tvTitle.setText(bookInstance.getTitle());
    holder.tvSubtitle.setText(bookInstance.getAuthor());
    String imageUrl = RetrofitConstants.BASE_URL
        + BOOK_COVER_ID_PATH
        + bookInstance.getImageId()
        + BOOK_COVER_SIZE
        + BOOK_COVER_EXTENSION;
    Glide.with(context).load(imageUrl).into(holder.ivCover);
    Log.i(TAG, imageUrl);
  }

  public void setBookList(List<Book> bookList) {
    this.bookList.clear();
    this.bookList.addAll(bookList);
    notifyDataSetChanged();
  }

  class BookViewHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.tv_item_title) TextView tvTitle;
    @Bind(R.id.tv_item_subtitle) TextView tvSubtitle;
    @Bind(R.id.iv_book_cover) ImageView ivCover;

    public BookViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }
}
