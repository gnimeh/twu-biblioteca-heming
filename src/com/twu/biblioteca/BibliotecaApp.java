package com.twu.biblioteca;

import com.twu.model.Biblioteca;
import com.twu.model.Book;
import com.twu.model.Menu;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {

    public static void main(String[] args) {
        PrintStream printStream = new PrintStream(System.out);
        List<Book> bookList = configBookList();
        Menu menu = configMenu();
        Biblioteca biblioteca = new Biblioteca(printStream,bookList,menu);
        biblioteca.start();
    }

    private static Menu configMenu() {
        List<String> options = new ArrayList<>();
        options.add("List Books");
        options.add("Checkout");
        options.add("quit");
        Menu menu = new Menu(options);
        return menu;
    }

    private static List<Book> configBookList() {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("book1","author1",2000));
        bookList.add(new Book("book2","author2",2001));
        bookList.add(new Book("book3","author3",2002));
        return bookList;
    }
}
