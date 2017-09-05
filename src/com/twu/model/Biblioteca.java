package com.twu.model;

import java.io.PrintStream;
import java.util.List;

public class Biblioteca {

    PrintStream printStream;
    List<Book> bookList;
    Menu menu;

    public Biblioteca(PrintStream printStream, List<Book> bookList,Menu menu) {
        this.printStream = printStream;
        this.bookList = bookList;
        this.menu = menu;
    }

    public void start() {
        welcome();
        showMenu();
    }

    public void showMenu(){
        printStream.println(menu.getMenuStr());
    }

    public void bookList() {
        String bookListStr = "";
        for (Book book :
                bookList) {
            bookListStr += book.toString();
        }
        printStream.println(bookListStr);
    }

    public void welcome() {
        printStream.println("Welcome to Biblioteca!");
    }
}
