package com.twu.model;

public class Base {
    String name;
    Boolean isCheckout;


    public Base() {
        this.isCheckout = false;
    }

    public String getName() {
        return this.name;
    }

    public Base checkout() {
        this.isCheckout = true;
        return this;
    }

    public Base returnBack() {
        this.isCheckout = false;
        return this;
    }
}
