package com.jose.books.data.book.retrofit.mapper;

import com.jose.books.data.book.retrofit.model.OLBookList;
import com.jose.books.domain.model.Book;

import java.util.List;

/**
 * Created by jose on 7/07/16.
 */
public interface BookApiToModelMapper {
    List<Book> mapBookListResponseToModel(OLBookList responseBookList);
}
