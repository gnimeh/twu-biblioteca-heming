package com.twu.model;

import java.io.PrintStream;
import java.util.List;

public class Biblioteca {

    PrintStream printStream;
    List<Book> bookList;

    public Biblioteca(PrintStream printStream, List<Book> bookList) {
        this.printStream = printStream;
        this.bookList = bookList;
    }

    public void start() {
        welcome();
        bookList();
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
