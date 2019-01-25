package job4j.convert;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.util.List;

public class ConvertListTest {
    @Test
    public void whenlistconvert() {
        ConvertList list = new ConvertList();
        list.add(new int[]{1, 2});
        list.add(new int[]{3, 4, 5, 6});
        List<Integer> result = list.convert();
        list.add2(1);
        list.add2(2);
        list.add2(3);
        list.add2(4);
        list.add2(5);
        list.add2(6);
        List<Integer> expect = list.ret();
        assertThat(result, is(expect));
    }
}
