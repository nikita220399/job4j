package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class QuestionTest {

    @Test
    public void whenArraySortThenTrue() {
        Question obj = new Question();
        int[] input = {1, 2, 3, 4, 5};
        boolean result = obj.sort(input);
        assertThat(result, is(true));
    }

    @Test
    public void whenArraySortThenFalse() {
        Question obj = new Question();
        int[] input = {1, 2, 5, 4, 5};
        boolean result = obj.sort(input);
        assertThat(result, is(false));
    }
}
