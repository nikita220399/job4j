package croc.task6;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Directory {

    private List<String> delete(String str) {
        List<String> array = Arrays.asList(str.split("/"));
        List<String> list = new LinkedList<>();
        int pointer = 0;
        for (int i = 0; i < array.size(); i++) {
            if (!array.get(i).equals("..") && !array.get(i).equals(".")) {
                list.add(array.get(i));
                pointer++;
                if (i >= 1 && array.get(i - 1).equals("..")) {
                    pointer += pointer*(-1) + 2;
                }
            }
            if (array.get(i).equals("..")) {
                pointer--;

                if (pointer > -1) {
                    int index = list.size() - 1;
                    list.remove(index);
                }
            } else if (array.get(i).equals("..") && array.get(i - 1).equals(".")) {
                pointer -= 2;
                if (pointer > -1) {
                    int index = list.size() - 1;
                    list.remove(index);
                }
            }
            if (pointer < 0) {
                list.add("..");
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Directory o = new Directory();
        String str = "КРОК/task_6_2/src/./../../task_6_1/../../../мемы/котики";
        List<String> del = o.delete(str);
        for (String a : del) {
            if (del.indexOf(a) != del.size() - 1) {
                System.out.print(a + '/');
            } else {
                System.out.println(a);
            }
        }

    }
}
