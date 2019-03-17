package croc.task3;

public class Point {
    private int x;
    private int y;
    private static char[] letter = new char[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};

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
        String str = String.valueOf(letter[x]);
        return (str + (++y));
    }

    public static Point transfer(String str) throws IllegalArgumentException {
        if (str.length() == 2) {
            int index = -1;
            int jndex = -1;
            char c1 = str.charAt(0);
            String str2 = str.substring(1);
            int c2 = Integer.parseInt(str2) - 1;
            for (int i = 0; i < letter.length; i++) {
                if (letter[i] == c1) {
                    index = i;
                    break;
                }
            }
            if (index == -1) {
                throw new IllegalArgumentException("Буква должна быть между А и G");
            }
            if (c2 >= 0 && c2 <= 7) {
                jndex = c2;
            } else if (jndex == -1) {
                throw new IllegalArgumentException("Цифра должна быть между 0 и 7");
            }
            Point point = new Point(index, jndex);
            return point;
        } else {
            throw new IllegalArgumentException("Название клетки должно состоять из 2 символов");
        }
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
