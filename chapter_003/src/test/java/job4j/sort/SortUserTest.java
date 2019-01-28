package job4j.sort;

import java.util.List;
import java.util.ArrayList;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {
    @Test
    public void whenGiveToSortLength() {
        SortUser check = new SortUser();
        List<User> hero = new ArrayList<>();
        hero.add(new User("Nik", 19));
        hero.add(new User("Alina", 25));
        hero.add(new User("Gala", 5));
        List<User> result = check.sortNameLength(hero);
        assertThat(hero.get(0).getName(), is("Alina"));
    }

    @Test
    public void whenGiveToSortNameAge() {
        SortUser check = new SortUser();
        List<User> hero = new ArrayList<>();
        hero.add(new User("Сергей", 25));
        hero.add(new User("Иван", 30));
        hero.add(new User("Сергей", 20));
        hero.add(new User("Иван", 25));
        List<User> result = check.sortByAllFields(hero);
        assertThat(hero.get(0).getName(), is("Иван"));
        assertThat(hero.get(0).getAge(), is(25));
        assertThat(hero.get(1).getName(), is("Иван"));
        assertThat(hero.get(1).getAge(), is(30));
        assertThat(hero.get(2).getName(), is("Сергей"));
        assertThat(hero.get(2).getAge(), is(20));
        assertThat(hero.get(3).getName(), is("Сергей"));
        assertThat(hero.get(3).getAge(), is(25));
    }
}
