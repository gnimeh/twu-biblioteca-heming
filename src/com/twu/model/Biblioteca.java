package com.twu.model;

import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Biblioteca {

    PrintStream printStream;
    List<Book> bookList;
    Menu menu;
    boolean isQuit;
    Scanner scanner;

    public boolean getIsQuit() {
        return this.isQuit;
    }


    public Biblioteca(PrintStream printStream, List<Book> bookList, Menu menu) {
        this.printStream = printStream;
        this.bookList = bookList;
        this.menu = menu;
        this.isQuit = false;
        this.scanner = new Scanner(System.in);
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
                .checkout(option)
                .returnBack(option)
                .quit(option);
    }

    public void showMenu() {
        printStream.println(menu.getMenuStr());
    }

    public Biblioteca bookList(String option) {
        if (option.equals("List Books")) {
            final String[] bookListStr = {""};
            bookList.forEach(book -> {
                if (!book.isCheckout) {
                    bookListStr[0] += book.toString();
                }
            });
            printStream.println(bookListStr[0]);
        }
        return this;
    }

    public String getInput() {
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
        if (option.equals("Quit")) {
            this.isQuit = true;
        }
        return this;
    }

    public Biblioteca checkout(String option) {
        if (option.equals("Checkout")) {
            printStream.println("Please input the book name you what to checkout");
            String bookName = scanner.nextLine();
            List<Book> checkoutBook = bookList.stream()
                    .filter(curBook -> curBook.getName().equals(bookName) & !curBook.isCheckout)
                    .collect(Collectors.toList());
            if (checkoutBook.size() <= 0) {
                printStream.println("That book is not available");
            } else {
                checkoutBook.get(0).checkout();
                printStream.println("Thank you! Enjoy the book");
            }
        }
        return this.bookList("bookList");
    }

    public Biblioteca returnBack(String option) {
        if (option.equals("Return")) {
            printStream.println("Please input the book name you what to return");
            String bookName = scanner.nextLine();
            List<Book> checkoutBook = bookList.stream()
                    .filter(curBook -> curBook.getName().equals(bookName) & curBook.isCheckout)
                    .collect(Collectors.toList());
            if (checkoutBook.size() <= 0) {
                printStream.println("That is not a valid book to return");
            } else {
                checkoutBook.get(0).returnBack();
                printStream.println("Thank you for returning the book.");
            }
        }
        return this.bookList("List Books");
    }
}
