package com.twu.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Biblioteca {

    List<Movie> movieList;
    private List<Book> bookList;
    private Menu menu;
    private boolean isQuit;
    private boolean isCheckout;
    private boolean isReturn;
    private boolean isMovie;
    private boolean isBook;

    private String output;
    private boolean hasName;

    public boolean getIsQuit() {
        return this.isQuit;
    }

    public Biblioteca() {
        this.bookList = configBookList();
        this.movieList = configMovieList();
        this.menu = configMenu();
        this.isQuit = false;
        this.isReturn = false;
        this.isCheckout = false;
        this.isMovie = false;
        this.isBook = false;
        this.hasName = false;
        this.output = "";
        showMenu();
    }

    private static Menu configMenu() {
        List<String> options = new ArrayList<>();
        options.add("List Books");
        options.add("List Movies");
        options.add("Checkout");
        options.add("Return");
        options.add("Quit");
        return new Menu(options);
    }

    private static List<Book> configBookList() {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("book1", "author1", 2000));
        bookList.add(new Book("book2", "author2", 2001));
        bookList.add(new Book("book3", "author3", 2002));
        return bookList;
    }

    private static List<Movie> configMovieList() {
        List<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie("movie1", "director1", 2000, 1));
        movieList.add(new Movie("movie2", "director2", 2001, 2));
        movieList.add(new Movie("movie3", "director3", 2002, 3));
        return movieList;
    }

    public void bookList() {
        final String[] bookListStr = {""};
        bookList.forEach(book -> {
            if (!book.isCheckout) {
                bookListStr[0] += book.toString();
            }
        });
        output = bookListStr[0];
    }

    private void movieList() {
        final String[] movieListStr = {""};
        movieList.forEach(movie -> {
            if (!movie.isCheckout) {
                movieListStr[0] += movie.toString();
            }
        });
        output = movieListStr[0];
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void showMenu() {
        output += menu.getMenuStr();
    }

    public void checkout(String input) {
        if (isMovie & hasName) {
            checkoutMovie(input);
        } else if (isBook & hasName) {
            checkoutBook(input);
        } else {
            chooseType(input);
        }
    }

    public void invalid() {
        output = "Select a valid option!";
    }

    public void quit() {
        this.isQuit = true;
    }

    public void returnBack(String input) {
        if (isMovie & hasName) {
            returnMovie(input);
        } else if (isBook & hasName) {
            returnBook(input);
        } else if (isMovie & !hasName) {
            output = "Please input the movie name you what to return";
        } else if (isBook & !hasName) {
            output = "Please input the book name you what to return";
        } else {
            chooseType(input);
        }
    }

    public String getOutput() {
        return output;
    }

    public void checkoutBook(String name) {
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
        hasName = false;
        isBook = false;
    }

    public void checkoutMovie(String name) {
        List<Movie> checkoutMovie = movieList.stream()
                .filter(curMovie -> curMovie.getName().equals(name) & !curMovie.isCheckout)
                .collect(Collectors.toList());
        if (checkoutMovie.size() <= 0) {
            output = "That movie is not available";
        } else {
            checkoutMovie.get(0).checkout();
            output = "Thank you! Enjoy the movie";
        }
        isCheckout = false;
        isMovie = false;
        hasName = false;
    }

    public void returnBook(String name) {
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
        isBook = false;
        hasName = false;
    }

    public void returnMovie(String name) {
        List<Movie> checkoutMovie = movieList.stream()
                .filter(curMovie -> curMovie.getName().equals(name) & curMovie.isCheckout)
                .collect(Collectors.toList());
        if (checkoutMovie.size() <= 0) {
            output = "That is not a valid movie to return";
        } else {
            checkoutMovie.get(0).returnBack();
            output = "Thank you for returning the movie.";
        }
        isReturn = false;
        isMovie = false;
        hasName = false;
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

    private void chooseType(String input) {
        if (input.equalsIgnoreCase("book")) {
            isBook = true;
            output = "Input the book name:";
            hasName = true;
        }
        if (input.equalsIgnoreCase("movie")) {
            isMovie = true;
            output = "Input the movie name:";
            hasName = true;
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
            case "List Movies": {
                movieList();
                break;
            }
            case "Return": {
                isReturn = true;
                output = "Movie or Book?";
                break;
            }
            case "Checkout": {
                isCheckout = true;
                output = "Movie or Book?";
                break;
            }
            default: {
                invalid();
                break;
            }

        }
    }
}
