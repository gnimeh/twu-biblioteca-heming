package com.twu.model;

import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Biblioteca {

    PrintStream printStream;
    List<Book> bookList;
    Menu menu;
    boolean isQuit = false;

    public boolean getIsQuit() {
        return this.isQuit;
    }


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
                .checkout(option)
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

    public Biblioteca checkout(String option) {
        if (option.equals("Checkout")) {
            printStream.println("Please input the book name you what to checkout");
            Scanner scanner = new Scanner(System.in);
            String bookName = scanner.nextLine();
            List<Book> checkoutBook = bookList.stream().filter(curBook ->
                    curBook.getName().equals(bookName)).collect(Collectors.toList());
            if (checkoutBook.size() <= 0) {
                printStream.println("That book is not available");
            } else {
                bookList.remove(checkoutBook.get(0));
                printStream.println("Thank you! Enjoy the book");
            }
        }
        return this;
    }
}
