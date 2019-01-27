package job4j.hero;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserConvertTest {
    @Test
    public void ListToMap() {
        UserConvert user = new UserConvert();
        List<User> hero = new ArrayList<>();
        hero.add(new User(1, "Nikita", "Moscow"));
        hero.add(new User(2, "Vlad", "Volgograd"));
        HashMap<Integer, User> result = user.process(hero);
        assertThat(result.get(1).getCity(), is("Moscow"));
        assertThat(result.get(2).getName(), is("Vlad"));
    }
}
