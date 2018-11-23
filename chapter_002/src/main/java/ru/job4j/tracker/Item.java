package ru.job4j.tracker;

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

    public String toString() {
        String ln = System.lineSeparator();
        return "GetId заявки : " + getId() + ln + "Имя заявки : " + this.name + ln + "Описание заявки : " + this.desc;
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

    public void setId(String id) {
        this.id = id;
    }
}
