package com.twu.model;

public class Movie extends Base {
    String name;
    String director;
    int publishedYear;
    int rate;
    Boolean isCheckout;

    public Movie() {

    }

    public Movie(String name, String director, int publishedYear, int rate) {
        this.name = name;
        this.director = director;
        this.publishedYear = publishedYear;
        this.rate = rate;
        this.isCheckout = false;
    }

    public static String type() {
        return "Movie";
    }

    public String toString() {
        return "Book name: " + name
                + " Director: " + director
                + " Published in " + publishedYear
                + " Rate: " + (rate == 0 ? "unrated" : rate)
                + "\n";
    }
}