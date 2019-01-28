package job4j.sort;

import java.util.*;

public class SortUser {
    private List<User> users = new ArrayList<>();

    public void add(User user) {
        this.users.add(user);
    }

    public List<User> sortNameLength (List<User> list) {
        list.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getName().length() < o2.getName().length() ? 1 : -1;
            }
        });
        return list;
    }

    public List<User> sortByAllFields (List<User> list) {
        list.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                int res = o1.getName().compareTo(o2.getName());
                return res != 0 ? res : Integer.compare(o1.getAge(), o2.getAge());
            }
        });
        return list;
    }
}
