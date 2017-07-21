package com.jose.books.data.book.retrofit;

import android.util.Log;

import com.jose.books.data.book.BookDataSource;
import com.jose.books.data.book.retrofit.mapper.BookApiToModelMapper;
import com.jose.books.data.book.retrofit.model.OLBookList;
import com.jose.books.domain.model.Book;

import java.io.IOException;
import java.util.ArrayList;
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

  private static final String TAG = "BookRetrofitSource";

  private RetrofitService retrofitService;
  private BookApiToModelMapper bookMapper;

  public BookRetrofitSource(BookApiToModelMapper bookApiToModelMapper) {
    bookMapper = bookApiToModelMapper;
    init();
  }

  private void init() {
    Retrofit retrofit = new Retrofit.Builder().baseUrl(RetrofitConstants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build();

    retrofitService = retrofit.create(RetrofitService.class);
  }

  @Override
  public List<Book> getBooks() {
    Call<OLBookList> call = retrofitService.getBooks();

    try {
      return doQuery(call);
    } catch (IOException e) {
      return new ArrayList<Book>();
    }
  }

  @Override
  public List<Book> getBooksByAuthor(String author) throws IOException {
    Call<OLBookList> call = retrofitService.getBooksByAuthor(author);

    return doQuery(call);
  }

  @Override
  public List<Book> getBooksByKey(String key) throws IOException {
    Call<OLBookList> call = retrofitService.getBooksByKey(key);

    return doQuery(call);
  }

  private List<Book> doQuery(Call<OLBookList> call) throws IOException {
    OLBookList olBookList;

    olBookList = call.execute().body();

    Log.i(TAG, "Response size: " + olBookList.getOlBookList().size());
    return bookMapper.mapBookListResponseToModel(olBookList);
  }
}
