package job4j.list2;

import java.util.ArrayList;
import java.util.List;

public class ConvertMatrix2List {
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for(int j = 0; j < array[0].length; j++) {
                list.add(array[i][j]);
            }
        }
        return list;
    }
}
