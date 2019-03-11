package croc.task2_2;

import java.util.Arrays;

public class Department {
    private String name;
    private Department[] child;
    private int time;

    public Department(Department[] child, int time, String name) {
        this.child = child;
        this.time = time;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department[] getChild() {
        return child;
    }

    public void setChild(Department[] child) {
        this.child = child;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", child=" + Arrays.toString(child) +
                ", time=" + time +
                '}';
    }
}
