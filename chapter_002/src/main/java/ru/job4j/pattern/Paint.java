package ru.job4j.pattern;

public class Paint {
    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }

    public static void main(String[] args) {
        Shape shape1 = new Triangle();
        System.out.println(shape1.draw());
        Shape shape2 = new Square();
        System.out.println(shape2.draw());
    }
}
