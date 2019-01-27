package job4j.hero;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class UserConvert {
    private HashMap<Integer, User> users = new HashMap<>();
    private List<User> persons = new ArrayList<>();

    public void add(User user) {
        this.persons.add(user);
    }

    public HashMap<Integer, User> process(List<User> list) {
        for (User check : list) {
            this.users.put(check.getId(), check);
        }
        return this.users;
    }
}
