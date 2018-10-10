package ru.job4j.loop;

public class Counter {
    public int add(int start, int finish) {
        int kolvo = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                kolvo += i;
            }
        }
        return kolvo;
    }
}