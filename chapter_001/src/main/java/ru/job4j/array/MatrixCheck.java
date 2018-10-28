package ru.job4j.array;

public class MatrixCheck {
    public boolean mono(boolean[][] data) {
        boolean result = true;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length; j++) {
                if (data[0].length % 2 == 0 && i == j && data[0][0] != data[i][j]) {
                    result = false;
                }
                if (data[0].length % 2 == 0 && i == data.length - j - 1 && data[0][data.length - 1] != data[i][j]) {
                    result = false;
                }
                if (data[0].length % 2 != 0 && i == j && i == data.length - j - 1 && data[0][0] != data[i][j]) {
                    result = false;
                }
            }
        }
        return result;
    }
}
