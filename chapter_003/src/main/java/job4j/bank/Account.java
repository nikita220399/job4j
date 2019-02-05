package job4j.bank;

public class Account {
    private int value; // колво денег
    private String requisites;

    public Account (int value, String requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    public int getValue() {
        return value;
    }

    public String getRequisites() {
        return requisites;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
