package ru.job4j.loop;

public class Board {
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int i = 0; i < height; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < width; j++) {
                    if (j % 2 == 0) {
                        screen.append("x");
                    } else {
                        screen.append(" ");
                    }
                }
                // добавляем перевод на новую строку.
                screen.append(ln);
            } else {
                for (int j = 0; j < width; j++) {
                    if (j % 2 == 0) {
                        screen.append(" ");
                    } else {
                        screen.append("x");
                    }
                }
                // добавляем перевод на новую строку.
                screen.append(ln);
            }
        }
        return screen.toString();
    }
}