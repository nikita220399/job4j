package ru.job4j.array;

public class Square {
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int i = 0, j = 1; i < bound && j <=bound; i++, j++) {
            rst[i] = (int) Math.pow(j, 2);
        }
        return rst;
    }
}