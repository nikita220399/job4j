package ru.job4j.array;

public class Check {
    public boolean mono(boolean[] data) {
        boolean result = false;
        int kolvo1 = 0, kolvo2 = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == true) {
                kolvo1++;
            } else {
                kolvo2++;
            }
        }
        if (kolvo1 == data.length || kolvo2 == data.length) {
            result = true;
        }
        return result;
    }
}