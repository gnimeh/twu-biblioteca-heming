package com.twu.model;

import java.io.PrintStream;

public class Biblioteca {

    PrintStream printStream;

    public Biblioteca(PrintStream printStream){
        this.printStream = printStream;
    }

    public void start(){
        welcome();
    }

    public void welcome(){
        printStream.println("Welcome to Biblioteca!");
    }
}
