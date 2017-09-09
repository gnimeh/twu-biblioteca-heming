package com.twu.model;

import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {

    PrintStream printStream;
    InputStreamReader inputStreamReader;
    List<Book> bookList;
    Menu menu;
    boolean isQuit = false;

    public Biblioteca(PrintStream printStream, List<Book> bookList,Menu menu) {
        this.printStream = printStream;
        this.bookList = bookList;
        this.menu = menu;
    }

    public void start() {
        welcome();
        while (!isQuit) {
            showMenu();
            Option option = menu.getOptionByTitle(getInput());
            isQuit = option.operation();
        }
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

    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input;
    }
    public void welcome() {
        printStream.println("Welcome to Biblioteca!");
    }
}
