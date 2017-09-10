package com.twu.model;

public class Book {
    String name;
    String author;
    int publishedYear;
    Boolean isCheckout;
    public Book(String name,String author,int publishedYear){
        this.name = name;
        this.author = author;
        this.publishedYear = publishedYear;
        this.isCheckout = false;
    }
    public String toString(){
        return "Book name: "+ name
                +" Author:" + author
                + " Published in " + publishedYear +"\n";
    }

    public String getName() {
        return this.name;
    }

    public Book checkout() {
        this.isCheckout = true;
        return this;
    }

    public Book returnBack() {
        this.isCheckout = false;
        return this;
    }
}
