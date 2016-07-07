package com.jose.books.data.book.retrofit.mapper;

import com.jose.books.data.book.retrofit.model.OLBook;
import com.jose.books.data.book.retrofit.model.OLBookList;
import com.jose.books.domain.model.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jose on 7/07/16.
 */
public class BookApiToModelMapperImp implements BookApiToModelMapper {

    @Override
    public List<Book> mapBookListResponseToModel(OLBookList responseBookList) {
        List<Book> bookList = new ArrayList<Book>();
        for(OLBook olBook : responseBookList.getOlBookList()){
            bookList.add(mapBookResponseToModel(olBook));
        }
        return bookList;
    }

    private Book mapBookResponseToModel(OLBook responseBook){
        String author = responseBook.getAuthor_name()[0];
        int publishYear = responseBook.getPublish_year()[0];
        Book book = new Book(responseBook.getKey(), responseBook.getTitle(), author, "");
        book.setPublishYear(publishYear);
        return book;
    }
}
