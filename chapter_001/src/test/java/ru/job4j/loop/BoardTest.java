package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BoardTest {
    @Test
    public void whenPaintBoardWithWidthThreeAndHeightThreeThenStringWithThreeColsAndThreeRows() {
        Board board = new Board();
        String result = board.paint(3, 3);
        String ln = System.lineSeparator();
        String expected = String.format("x x%s x %sx x%s", ln, ln, ln);
        assertThat(result, is(expected));
    }

    @Test
    public void whenPaintBoardWithWidthFiveAndHeightFourThenStringWithFiveColsAndFourRows() {
        Board board = new Board();
        String result = board.paint(5, 4);
        String ln = System.lineSeparator();
        String expected = String.format("x x x%s x x %sx x x%s x x %s", ln, ln, ln, ln);
        assertThat(result, is(expected));
    }
}