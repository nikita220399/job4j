package croc.messenger.messenger.server;

public class Item {
    private String id;
    private String name;
    private String desc;

    public Item() {
    }

    public Item(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String toString(int i) {
        String ln = System.lineSeparator();
        return ln + ln + "      Item #" + i + ln + "ID : " + getId() + ln + "Name : " + this.name + ln + "Description : " + this.desc;
    }

    public String toString2() {
        String ln = System.lineSeparator();
        return ln + ln + "ID : " + getId() + ln + "Name : " + this.name + ln + "Description : " + this.desc;
    }

    public String getName() {
        return this.name;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getId() {
        return this.id;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setId(String id) {
        this.id = id;
    }
}