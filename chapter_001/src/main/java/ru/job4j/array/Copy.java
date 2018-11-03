package ru.job4j.array;

// Задание: Есть 2 неотсортированных массива. Переместить все элементы в 3 массив и сортировать его по возрастанию
public class Copy {
    public int[] sort (int[] array1, int[] array2) {
        int count = array1.length + array2.length;

        int[] res = new int[count];
        int i = 0;
        for (; i < array1.length; i++) {
            res[i] = array1[i];
        }

        for (int j = 0; j < array2.length; i++, j++) {
            res[i] = array2[j];
        }

        int temp = 0;
        // метод пузырька
        for (int i1 = 0; i1 < count - 1; i1++) {
            for (int j1 = 0; j1 < count - i1 - 1; j1++) {
                if (res[j1] > res[j1 + 1]) {
                    temp = res[j1 + 1];
                    res[j1 + 1] = res[j1];
                    res[j1] = temp;
                }
            }
        }
        return res;
    }
}
