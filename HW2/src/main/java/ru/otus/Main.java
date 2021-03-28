package ru.otus;

import static ru.otus.CalculateMemory.printUsage;

public class Main {
    public static final int SIZE = 100_000;

    public static void main(String[] args) {
        printUsage(String::new, "Empry string");
        printUsage(Object::new, "Empry object");
    }
}
