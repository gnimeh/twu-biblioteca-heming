package com.twu.model;

public class Movie {
    String name;
    String director;
    int publishedYear;
    int rate;
    Boolean isCheckout;

    public Movie(String name, String director, int publishedYear, int rate) {
        this.name = name;
        this.director = director;
        this.publishedYear = publishedYear;
        this.rate = rate;
        this.isCheckout = false;
    }

    public String toString() {
        return "Book name: " + name
                + " Director: " + director
                + " Published in " + publishedYear
                + " Rate: " + (rate == 0 ? "unrated" : rate)
                + "\n";
    }

    public String getName() {
        return this.name;
    }

    public Movie checkout() {
        this.isCheckout = true;
        return this;
    }

    public Movie returnBack() {
        this.isCheckout = false;
        return this;
    }
}