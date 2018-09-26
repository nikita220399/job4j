package ru.job4j.calculator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {
    @Test
    public void whenAddOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        calc.add(1.0, 1.0);
        double result = calc.getResult();
        double expected = 2.0;
        assertThat(result, is(expected));
    }
	@Test
	public void whenAddOnesubtactOneThenZero() {
        Calculator calc = new Calculator();
        calc.subtact(1.0, 1.0);
        double result = calc.getResult();
        double expected = 0.0;
        assertThat(result, is(expected));
    }
	@Test
	public void whenAddOnedivOneThenOne() {
        Calculator calc = new Calculator();
        calc.div(1.0, 1.0);
        double result = calc.getResult();
        double expected = 1.0;
        assertThat(result, is(expected));
    }
	@Test
	public void whenAddOnemultipleOneThenOne() {
        Calculator calc = new Calculator();
        calc.multiple(1.0, 1.0);
        double result = calc.getResult();
        double expected = 1.0;
        assertThat(result, is(expected));
    }
}