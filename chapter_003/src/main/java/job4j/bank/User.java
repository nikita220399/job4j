package job4j.bank;

public class User {
    private String name;
    private String passpot;

    public User (String name, String passpot) {
        this.name = name;
        this.passpot = passpot;
    }

    public String getName() {
        return name;
    }

    public String getPasspot() {
        return passpot;
    }
}
