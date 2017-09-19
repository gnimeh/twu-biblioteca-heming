package com.twu.model;

import java.io.PrintStream;
import java.util.List;
import java.util.stream.Collectors;

public class Biblioteca {

    PrintStream printStream;
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


    public Biblioteca(List<Book> bookList, Menu menu) {
        this.bookList = bookList;
        this.menu = menu;
        this.isQuit = false;
        this.isShowMenu = true;
        this.isBookList = false;
        this.isReturn = false;
        this.isCheckout = false;
        this.output = "";
    }

    public void showMenu() {
        output = menu.getMenuStr();
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

    public String invalid() {
        return "Select a valid option!";
    }

    public Biblioteca quit(String option) {
        if (option.equals("Quit")) {
            this.isQuit = true;
        }
        return this;
    }

    public void checkout() {
        output = "Please input the book name you what to checkout";
        this.isCheckout = true;
    }

    public void checkout(String name) {
        List<Book> checkoutBook = bookList.stream()
                .filter(curBook -> curBook.getName().equals(name) & !curBook.isCheckout)
                .collect(Collectors.toList());
        if (checkoutBook.size() <= 0) {
            printStream.println("That book is not available");
        } else {
            checkoutBook.get(0).checkout();
            printStream.println("Thank you! Enjoy the book");
        }
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
    }

    public void returnBack() {
        output = "Please input the book name you what to return";
        isReturn = true;
    }

    public String getOutput() {
        return output;
    }

    public void operate(String input) {
        if (isCheckout) {
            checkout(input);
        } else if (isReturn) {
            returnBack(input);
        } else {
            optionOperate(input);
        }
    }

    public void optionOperate(String option) {
        switch (option) {
            case "Quit": {
                isQuit = true;
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
