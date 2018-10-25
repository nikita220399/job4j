package ru.job4j.array;

public class Check {
    public boolean mono(boolean[] data) {
        boolean result = true;
        for (int i = 0, j = 1; j < data.length; j++) {
            if (data[i] != data[j]) {
                result = false;
                break;
            }
        }
        return result;
    }
}