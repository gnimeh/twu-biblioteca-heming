package com.twu.biblioteca;


import com.twu.model.Biblioteca;
import org.hamcrest.core.Is;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BibliotecaTest {


    @Test
    public void should_display_book_list() {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.bookList();
        String bookListStr = "Book name: book1 Author:author1 Published in 2000\n" +
                "Book name: book2 Author:author2 Published in 2001\n" +
                "Book name: book3 Author:author3 Published in 2002\n";
        assertThat(biblioteca.getOutput(), Is.is(bookListStr));
    }

    @Test
    public void should_show_menu() {
        Biblioteca biblioteca = new Biblioteca();
        assertThat(biblioteca.getOutput(), Is.is("Menu:\n--------------------" +
                "\nList Books\nList Movies\nLogin\nCheckout\nReturn\nQuit\n"));
    }

    @Test
    public void should_not_get_option_with_invalid_title() {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.operate("invalid");
        assertThat(biblioteca.getOutput(), is("Select a valid option!"));
    }


    @Test
    public void should_quit() {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.quit();
        assertThat(biblioteca.getIsQuit(), is(true));
    }

    @Test
    public void should_checkout_book() {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.optionOperate("Checkout");
        biblioteca.checkout("Book");
        assertThat(biblioteca.getOutput(), is("Input the book name:"));
    }

    @Test
    public void should_checkout_book_successful() {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.checkoutBook("book1");
        assertThat(biblioteca.getOutput(), is("Thank you! Enjoy the book"));
    }

    @Test
    public void should_checkout_book_failed() {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.checkoutBook("book4");
        assertThat(biblioteca.getOutput(), is("That book is not available"));
    }

    @Test
    public void should_return_book() {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.optionOperate("Return");
        biblioteca.returnBack("Book");
        assertThat(biblioteca.getOutput(), is("Input the book name:"));
    }

    @Test
    public void should_return_book_successful() {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.getBookList().get(0).checkout();
        biblioteca.returnBack("book");
        biblioteca.returnBook("book1");
        assertThat(biblioteca.getOutput(), is("Thank you for returning the book."));
    }

    @Test
    public void should_return_book_failed() {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.returnBack("Book");
        biblioteca.returnBook("book1");
        assertThat(biblioteca.getOutput(), is("That is not a valid book to return"));
    }

}
