package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class WordTest {
    @Test
    public void whenStartWithPrefixThenTrue() {
        Word word = new Word("Hello");
        boolean result = word.startWith("He");
        assertThat(result, is(true));
    }

    @Test
    public void whenNotStartWithPrefixThenFalse() {
        Word word = new Word("Hello");
        boolean result = word.startWith("Hi");
        assertThat(result, is(false));
    }
}