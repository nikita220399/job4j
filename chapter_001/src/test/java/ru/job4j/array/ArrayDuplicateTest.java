package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.junit.Assert.assertThat;

public class ArrayDuplicateTest {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        String input[] = {"Привет", "Мир", "Привет", "Супер", "Привет"};
        String output[] = {"Привет", "Мир", "Супер"};
        ArrayDuplicate ar = new ArrayDuplicate();
        String[] result = ar.remove(input);
        assertThat(result, arrayContainingInAnyOrder(output));
    }

    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate2() {
        String[] input = {"Привет", "Привет", "Привет", "Привет"};
        String[] output = {"Привет"};
        ArrayDuplicate ar = new ArrayDuplicate();
        String[] result = ar.remove(input);
        assertThat(result, arrayContainingInAnyOrder(output));
    }
}

