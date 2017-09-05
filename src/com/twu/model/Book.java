package com.twu.model;

public class Book {
    String name;
    String author;
    int publishedYear;
    public Book(String name,String author,int publishedYear){
        this.name = name;
        this.author = author;
        this.publishedYear = publishedYear;
    }
    public String toString(){
        return "Book name: "+ name
                +" Author:" + author
                + " Published in " + publishedYear +"\n";
    }
}
