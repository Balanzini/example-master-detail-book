package com.jose.books.data.book.retrofit;

import android.util.Log;

import com.jose.books.data.book.BookDataSource;
import com.jose.books.data.book.retrofit.model.OLBook;
import com.jose.books.data.book.retrofit.model.OLBookList;
import com.jose.books.domain.Book;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jose on 7/07/16.
 */
public class BookRetrofitSource implements BookDataSource {

    private RetrofitService retrofitService;

    public BookRetrofitSource(){
        init();
    }

    private void init(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RetrofitConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofitService = retrofit.create(RetrofitService.class);

    }
    @Override
    public List<Book> getBooks() {
        Call<OLBookList> call = retrofitService.getBooks();

        call.enqueue(new Callback<OLBookList>() {
            @Override
            public void onResponse(Call<OLBookList> call, Response<OLBookList> response) {
                Log.i("retrofit", response.body().getOlBookList().get(0).getTitle());
            }

            @Override
            public void onFailure(Call<OLBookList> call, Throwable t) {

            }
        });

        return null;
    }
}
