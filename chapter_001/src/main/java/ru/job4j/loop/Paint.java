package ru.job4j.loop;

public class Paint {
    public String pyramid(int height) {
        StringBuilder screen = new StringBuilder();
        int weight = 2 * height - 1;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < weight; j++) {
                if ((i >= -j + height - 1) && (i + height - 1 >= j)) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }
}