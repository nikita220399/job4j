package job4j.sort;

import java.util.Set;
import java.util.TreeSet;
import java.util.List;
import java.util.ArrayList;

public class SortUser {
    private List<User> persons = new ArrayList<>();
    private TreeSet<User> users = new TreeSet<>();

    public void add(User user) {
        this.persons.add(user);
    }

    TreeSet<User> sort (List<User> list) {
        for (User check : list) {
            this.users.add(check);
        }
        return this.users;
    }
}
