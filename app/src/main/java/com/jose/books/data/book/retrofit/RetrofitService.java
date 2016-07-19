package com.jose.books.data.book.retrofit;

import com.jose.books.data.book.retrofit.model.OLBookList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by jose on 7/07/16.
 */
public interface RetrofitService {

    @GET(RetrofitConstants.BOOK_SEARCH)
    Call<OLBookList> getBooks();

    @GET(RetrofitConstants.BOOK_SEARCH_QUERY)
    Call<OLBookList> getBooksByAuthor(@Query("author") String author);
}
