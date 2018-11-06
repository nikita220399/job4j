package ru.job4j.array;

// Задание: Есть 2 отсортированных массива. Нужно их добавить в третий, что бы он сразу был отсортирован

public class Sortirovka {
    public int[] sort (int[] array1, int[] array2) {
        int count = array1.length + array2.length;
        int res[] = new int[count];
        int k = -1;
        for (int i = 0; i < array1.length;) {
            for (int j = ...; j < array2.length; j++) {
                if (array1[i] >= array2[j]) {
                    res[++k] = array2[j];
                } else {
                    res[++k] = array1[i];
                    break;
                }
            }
            if (i < array1.length - 1) {
                i++;
            }
        }
        return res;
    }
}
