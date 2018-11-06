package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortirovkaTest {

    @Test
    public void whenArray1And2ThenArray3Sort() {
        Sortirovka obj = new Sortirovka();
        int[] array1 = {1, 8, 9};
        int[] array2 = {2, 4, 5, 7};
        int[] res = obj.sort(array1, array2);
        int[] expect = {1, 2, 4, 5, 7, 8, 9};
        assertThat(res, is(expect));
    }
}