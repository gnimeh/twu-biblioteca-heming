package com.twu.biblioteca;

import com.twu.model.Biblioteca;

import java.io.PrintStream;
import java.util.Scanner;

public class BibliotecaApp {

    private static PrintStream printStream = new PrintStream(System.out);
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        welcome();
        while (!biblioteca.getIsQuit()) {
            printStream.println(biblioteca.getOutput());
            biblioteca.operate(getInput());
        }
    }

    private static void welcome() {
        printStream.println("Welcome to Biblioteca!");
    }

    public static String getInput() {
        return scanner.nextLine();
    }

}
