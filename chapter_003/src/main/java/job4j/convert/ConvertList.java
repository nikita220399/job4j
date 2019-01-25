package job4j.convert;

import java.util.List;
import java.util.ArrayList;

public class ConvertList {
    private List<int[]> list1 = new ArrayList<>();
    private List<Integer> list2 = new ArrayList<>();
    private List<Integer> test = new ArrayList<>();

    public void add (int[] array) {
        this.list1.add(array);
    }

    public List<Integer> convert() {
        for (int[] arr : this.list1) {
            for (int i = 0; i < arr.length; i++) {
                this.list2.add(arr[i]);
            }
        }
        return this.list2;
    }

    public void add2 (int array) {
        this.test.add(array);
    }

    public List<Integer> ret() {
        return this.test;
    }
}
