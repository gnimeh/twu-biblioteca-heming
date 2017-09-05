package com.twu.biblioteca;


import com.twu.model.Biblioteca;
import com.twu.model.Book;
import org.junit.Before;
import org.junit.Test;

import java.io.Console;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ExampleTest {

    private PrintStream printStream;
    private List<Book> bookList;
    private Biblioteca biblioteca;


    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
    }


    @Test
    public void should_show_welcome_message(){
        bookList = buildBookList();
        Biblioteca biblioteca = new Biblioteca(printStream,bookList);
        biblioteca.welcome();
        verify(printStream).println("Welcome to Biblioteca!");
    }

    @Test
    public void should_display_book_list(){
        bookList = buildBookList();
        Biblioteca biblioteca = new Biblioteca(printStream,bookList);
        biblioteca.bookList();
        verify(printStream).println("book1\nbook2\nbook3\n");
    }

    private List<Book> buildBookList(){
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("book1"));
        bookList.add(new Book("book2"));
        bookList.add(new Book("book3"));
        return bookList;
    }
}
