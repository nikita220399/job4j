package ru.job4j.array;

// Задание: проверить, отсортирован ли массив по возрастанию?
public class Question {
    public boolean sort(int[] array) {
        boolean flag = true;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
