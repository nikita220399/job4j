package job4j.sort;

public class User implements Comparable<User>{
    private String name;
    private int age;

    public User (String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public int compareTo(User o) {
        return this.age > o.age ? 1 : -1;
    }
}
