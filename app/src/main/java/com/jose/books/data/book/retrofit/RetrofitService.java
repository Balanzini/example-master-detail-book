package com.jose.books.data.book.retrofit;

import com.jose.books.data.book.retrofit.model.OLBookList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by jose on 7/07/16.
 */
public interface RetrofitService {

    @GET(RetrofitConstants.BOOK_SEARCH)
    Call<OLBookList> getBooks();

}
