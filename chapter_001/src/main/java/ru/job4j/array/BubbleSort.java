package ru.job4j.array;

public class BubbleSort {
    public int[] sort(int[] array) {
        int temp = 0;
        // сортировка методом устновки, он мне намного удобнее чем пузырьком
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[j] > array[i]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }
}