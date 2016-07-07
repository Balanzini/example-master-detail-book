package com.jose.books.domain.repository;

import android.util.Log;

import com.jose.books.domain.model.Book;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.when;

/**
 * Created by jose on 7/07/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class BookRepositoryTest {

    @Mock
    private BookRepository bookRepository;

    @Mock
    private Book book1;

    @Mock
    private Book book2;
    private String id1 = "id1";
    private String id2 = "id2";

    @Before
    public void init(){
        when(bookRepository.getBookById(id1)).thenReturn(book1);
        when(book1.getId()).thenReturn(id1);
        when(book2.getId()).thenReturn(id2);
    }

    @Test
    public void getBookTest(){
        Book b = bookRepository.getBookById(id1);
        assertTrue(b.getId() == book1.getId());
        assertFalse(b.getId() == book2.getId());
        assertTrue(book1.getId() != book2.getId());
    }
}

