package com.twu.biblioteca;

import com.twu.model.Biblioteca;
import com.twu.model.Book;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {

    public static void main(String[] args) {
        PrintStream printStream = new PrintStream(System.out);
        List<Book> bookList = new ArrayList<>();
        Biblioteca biblioteca = new Biblioteca(printStream,bookList);
        biblioteca.start();
    }
}
