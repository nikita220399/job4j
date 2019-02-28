package croc.task1_1;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LatinTest {
    @Test
    public void whenStrThenSwapStr() {
        Latin latin = new Latin();
        String result = latin.swap("palindrome");
        String answer = "pelondrima";
        assertThat(result, is(answer));
    }
}
