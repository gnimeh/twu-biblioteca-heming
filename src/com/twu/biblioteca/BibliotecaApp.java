package com.twu.biblioteca;

import com.twu.model.Biblioteca;
import com.twu.model.Book;
import com.twu.model.Menu;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {

    private static PrintStream printStream = new PrintStream(System.out);
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Book> bookList = configBookList();
        Menu menu = configMenu();
        Biblioteca biblioteca = new Biblioteca(bookList, menu);
        welcome();
        while (!biblioteca.getIsQuit()) {
            printStream.println(biblioteca.getOutput());
            biblioteca.operate(getInput());
        }
    }

    private static void welcome() {
        printStream.println("Welcome to Biblioteca!");
    }

    public static String getInput() {
        return scanner.nextLine();
    }

    private static Menu configMenu() {
        List<String> options = new ArrayList<>();
        options.add("List Books");
        options.add("Checkout");
        options.add("Return");
        options.add("Quit");
        Menu menu = new Menu(options);
        return menu;
    }

    private static List<Book> configBookList() {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("book1", "author1", 2000));
        bookList.add(new Book("book2", "author2", 2001));
        bookList.add(new Book("book3", "author3", 2002));
        return bookList;
    }
}
