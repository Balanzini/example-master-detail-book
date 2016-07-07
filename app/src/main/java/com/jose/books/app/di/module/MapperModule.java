package com.jose.books.app.di.module;

import com.jose.books.data.book.retrofit.mapper.BookApiToModelMapper;
import com.jose.books.data.book.retrofit.mapper.BookApiToModelMapperImp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jose on 7/07/16.
 */
@Module
public class MapperModule {

    @Provides
    @Singleton
    BookApiToModelMapper provideBookApiToModelMapper(){
        return new BookApiToModelMapperImp();
    }
}
