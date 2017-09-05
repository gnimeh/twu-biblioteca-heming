package com.twu.biblioteca;

import com.twu.model.Biblioteca;

import java.io.PrintStream;

public class BibliotecaApp {

    public static void main(String[] args) {
        PrintStream printStream = new PrintStream(System.out);
        Biblioteca biblioteca = new Biblioteca(printStream);
        biblioteca.start();
    }
}
