package com.company;

public class Main {

    public static void main(String[] args) {

        Printer xerox = new Printer(45,32,false);
        xerox.addToner(0);
        xerox.printPages(544);
        xerox.printPages(722);
    }
}
