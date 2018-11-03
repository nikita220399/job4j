package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CopyTest {

    @Test
    public void whenArray1And2ThenArray3Sort() {
        Copy obj = new Copy();
        int[] array1 = {1, 3, 2};
        int[] array2 = {1, 4, 5, 7};
        int[] res = obj.sort(array1, array2);
        int[] expect = {1, 1, 2, 3, 4, 5, 7};
        assertThat(res, is(expect));
    }
}
