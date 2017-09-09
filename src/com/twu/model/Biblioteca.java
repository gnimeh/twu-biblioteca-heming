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

    public Biblioteca(PrintStream printStream, List<Book> bookList, Menu menu) {
        this.printStream = printStream;
        this.bookList = bookList;
        this.menu = menu;
    }

    public void start() {
        welcome();
        while (!isQuit) {
            showMenu();
            String option = menu.getOptionByTitle(getInput());
            isQuit = operation(option).isQuit;
        }
    }

    private Biblioteca operation(String option) {
        return this.invalid(option)
                .bookList(option)
                .quit(option);
    }

    public void showMenu() {
        printStream.println(menu.getMenuStr());
    }

    public Biblioteca bookList(String option) {
        if (option.equals("List Books")) {
            final String[] bookListStr = {""};
            bookList.forEach(book -> bookListStr[0] += book.toString());
            printStream.println(bookListStr[0]);
        }
        return this;
    }

    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input;
    }

    public void welcome() {
        printStream.println("Welcome to Biblioteca!");
    }

    public Biblioteca invalid(String option) {
        if (option.equals("invalid")) {
            printStream.println("Select a valid option!");
        }
        return this;
    }

    public Biblioteca quit(String option) {
        if (option.equals("quit")) {
            this.isQuit = true;
        }
        return this;
    }

}
