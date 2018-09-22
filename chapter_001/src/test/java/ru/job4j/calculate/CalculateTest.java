package ru.job4j.calculate;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**

* Test.
*
* @author Nikita Karuk (nik.karuk99@mail.ru)
* @version $Id$
* @since 22.09.2018
*/
public class CalculateTest {
/**

* Test echo.
*/
    @Test
    public void whenTakeNameThenTreeEchoPlusName() {
        String input = "Nikita Karuk";
        String expect = "Echo, echo, echo : Nikita Karuk"; 
        Calculate calc = new Calculate();
        String result = calc.echo(input);
        assertThat(result, is(expect));
	}	
}