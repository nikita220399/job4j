package croc.task3;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) throws IllegalArgumentException {
        if (x >= 0 && x <= 7) {
            this.x = x;
        } else {
            throw new IllegalArgumentException("Х должен быть между 0 и 7");
        }
        if (y >= 0 && y <= 7) {
            this.y = y;
        } else {
            throw new IllegalArgumentException("Y должен быть между 0 и 7");
        }
    }

    public String toString(int x, int y) {
        String[] letter = new String[] {"a", "b", "c", "d", "e", "f", "g", "h"};
        return (letter[x] + (++y));
    }

    public void setX(int x) throws IllegalArgumentException {
        if (x >= 0 && x <= 7) {
            this.x = x;
        } else {
            throw new IllegalArgumentException("Х должен быть между 0 и 7");
        }
    }

    public void setY(int y) throws IllegalArgumentException {
        if (y >= 0 && y <= 7) {
            this.y = y;
        } else {
            throw new IllegalArgumentException("Y должен быть между 0 и 7");
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
