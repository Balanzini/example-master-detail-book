package com.jose.books.ui.list.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jose.books.R;
import com.jose.books.domain.model.Book;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jose on 12/07/16.
 */
public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {

    private List<Book> bookList;

    public BookAdapter(){
        bookList = new ArrayList<>();
    }

    @Override
    public BookViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
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

    private void setBookHolder(Book bookInstance, BookViewHolder holder){
        holder.tvTitle.setText(bookInstance.getTitle());
        holder.tvSubtitle.setText(bookInstance.getAuthor());
    }

    public void setBookList(List<Book> bookList){
        this.bookList.clear();
        this.bookList.addAll(bookList);
        notifyDataSetChanged();
    }

    class BookViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.tv_item_title)
        TextView tvTitle;
        @BindView(R.id.tv_item_subtitle) TextView tvSubtitle;

        public BookViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
