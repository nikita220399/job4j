package job4j.sort;

import java.util.TreeSet;
import java.util.List;
import java.util.ArrayList;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {
    @Test
    public void whenGiveToSort() {
        SortUser check = new SortUser();
        List<User> hero = new ArrayList<>();
        hero.add(new User("Nikita", 19));
        hero.add(new User("Alina", 25));
        hero.add(new User("Gala", 5));
        TreeSet<User> result = check.sort(hero);
        assertThat(result.first().getName(), is("Gala"));
    }
}
