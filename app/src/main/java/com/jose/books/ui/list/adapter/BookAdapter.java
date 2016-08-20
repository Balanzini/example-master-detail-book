package com.jose.books.ui.list.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.Bind;
import com.bumptech.glide.Glide;
import com.jose.books.R;
import com.jose.books.data.book.Constants;
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

  private List<Book> bookList;
  private Context context;
  private Animation animRotate;
  private Animation animTranslate;
  private boolean duringAnim = false;
  private OnClick onClick;
  private String bookIdClicked;

  public BookAdapter() {
    bookList = new ArrayList<>();
  }

  @Override
  public BookViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    context = parent.getContext();
    animRotate = AnimationUtils.loadAnimation(context, R.anim.rotate_anim);
    animTranslate = AnimationUtils.loadAnimation(context, R.anim.translate_anim);
    animTranslate.setAnimationListener(new Animation.AnimationListener() {
      @Override
      public void onAnimationStart(Animation animation) {

      }

      @Override
      public void onAnimationEnd(Animation animation) {
        duringAnim = false;
        onClick.onBookClicked(bookIdClicked);
      }

      @Override
      public void onAnimationRepeat(Animation animation) {

      }
    });

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

  private void setBookHolder(final Book bookInstance, final BookViewHolder holder) {
    holder.tvTitle.setText(bookInstance.getTitle());
    holder.tvSubtitle.setText(bookInstance.getAuthor());
    String imageUrl = Constants.BOOK_COVER_ID_PATH
        + bookInstance.getImageId()
        + Constants.BOOK_COVER_SIZE_M
        + Constants.BOOK_COVER_EXTENSION;

    if (bookInstance.getImageId().compareTo("0") == 0) {

      Glide.with(context).load(R.drawable.error).into(holder.ivCover);
    } else {
      Glide.with(context)
          .load(imageUrl)
          .placeholder(R.drawable.search)
          .error(R.drawable.error)
          .into(holder.ivCover);
    }
    Log.i(TAG, bookInstance.getId());
    Log.i(TAG, imageUrl);

    holder.llItem.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        if (!duringAnim) {
          duringAnim = true;
          holder.llItem.startAnimation(animTranslate);
          bookIdClicked = bookInstance.getId();
        }
      }
    });
  }

  public void setBookList(List<Book> bookList) {
    this.bookList.clear();
    this.bookList.addAll(bookList);
    notifyDataSetChanged();
  }

  public void setOnClick(OnClick onClick) {
    this.onClick = onClick;
  }

  public interface OnClick {
    void onBookClicked(String bookId);
  }

  class BookViewHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.tv_item_title) TextView tvTitle;
    @Bind(R.id.tv_item_subtitle) TextView tvSubtitle;
    @Bind(R.id.iv_book_cover) ImageView ivCover;
    @Bind(R.id.ll_item_list) LinearLayout llItem;

    public BookViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }
}
