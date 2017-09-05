package com.twu.biblioteca;


import com.twu.model.Biblioteca;
import org.junit.Before;
import org.junit.Test;

import java.awt.print.Book;
import java.io.Console;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ExampleTest {

    private PrintStream printStream;
    private Biblioteca biblioteca;


    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
    }


    @Test
    public void should_show_welcome_message(){
        Biblioteca biblioteca = new Biblioteca(printStream);
        biblioteca.welcome();
        verify(printStream).println("Welcome to Biblioteca!");
    }
}
