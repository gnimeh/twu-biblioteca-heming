package com.twu.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Biblioteca {

    List<Book> bookList;
    Menu menu;
    boolean isQuit;
    boolean isShowMenu;
    boolean isBookList;
    boolean isCheckout;
    boolean isReturn;

    private String output;

    public boolean getIsQuit() {
        return this.isQuit;
    }

    public Biblioteca() {
        this.bookList = configBookList();
        this.menu = configMenu();
        this.isQuit = false;
        this.isShowMenu = true;
        this.isBookList = false;
        this.isReturn = false;
        this.isCheckout = false;
        this.output = "";
        showMenu();
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

    public void bookList() {
        isBookList = true;
        final String[] bookListStr = {""};
        bookList.forEach(book -> {
            if (!book.isCheckout) {
                bookListStr[0] += book.toString();
            }
        });
        output = bookListStr[0];
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void showMenu() {
        output += menu.getMenuStr();
    }

    public void checkout() {
        output = "Please input the book name you what to checkout";
        this.isCheckout = true;
    }

    public void invalid() {
        output = "Select a valid option!";
    }

    public void quit() {
        this.isQuit = true;
    }

    public void returnBack() {
        output = "Please input the book name you what to return";
        isReturn = true;
    }

    public String getOutput() {
        return output;
    }

    public void checkout(String name) {
        List<Book> checkoutBook = bookList.stream()
                .filter(curBook -> curBook.getName().equals(name) & !curBook.isCheckout)
                .collect(Collectors.toList());
        if (checkoutBook.size() <= 0) {
            output = "That book is not available";
        } else {
            checkoutBook.get(0).checkout();
            output = "Thank you! Enjoy the book";
        }
        isCheckout = false;
    }

    public void returnBack(String name) {
        List<Book> checkoutBook = bookList.stream()
                .filter(curBook -> curBook.getName().equals(name) & curBook.isCheckout)
                .collect(Collectors.toList());
        if (checkoutBook.size() <= 0) {
            output = "That is not a valid book to return";
        } else {
            checkoutBook.get(0).returnBack();
            output = "Thank you for returning the book.";
        }
        isReturn = false;
    }

    public void operate(String input) {
        if (isCheckout) {
            checkout(input);
            showMenu();
        } else if (isReturn) {
            returnBack(input);
            showMenu();
        } else {
            optionOperate(input);
        }
    }

    public void optionOperate(String option) {
        switch (option) {
            case "Quit": {
                quit();
                break;
            }
            case "List Books": {
                bookList();
                break;
            }
            case "Return": {
                returnBack();
                break;
            }
            case "Checkout": {
                checkout();
                break;
            }
            default: {
                invalid();
                break;
            }

        }
    }
}
