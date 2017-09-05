package com.twu.biblioteca;


import com.twu.model.Biblioteca;
import com.twu.model.Book;
import com.twu.model.Menu;
import com.twu.model.Option;
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
        Biblioteca biblioteca = buildBibloteca();
        biblioteca.welcome();
        verify(printStream).println("Welcome to Biblioteca!");
    }

    @Test
    public void should_display_book_list(){
        Biblioteca biblioteca = buildBibloteca();
        biblioteca.bookList();
        String bookListStr = "Book name: book1 Author:author1 Published in 2000\n" +
                "Book name: book2 Author:author2 Published in 2001\n" +
                "Book name: book3 Author:author3 Published in 2002\n";
        verify(printStream).println(bookListStr);
    }

    @Test
    public void should_show_menu(){
        Biblioteca biblioteca = buildBibloteca();
        biblioteca.showMenu();
        verify(printStream).println("List Books");
    }

    private Biblioteca buildBibloteca(){
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("book1","author1",2000));
        bookList.add(new Book("book2","author2",2001));
        bookList.add(new Book("book3","author3",2002));
        List<Option> options = new ArrayList<>();
        options.add(new Option("List Books"));
        Menu menu = new Menu(options);
        Biblioteca biblioteca = new Biblioteca(printStream,bookList,menu);
        return biblioteca;
    }

}
