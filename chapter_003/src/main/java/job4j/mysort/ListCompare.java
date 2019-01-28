package job4j.mysort;

import java.util.Comparator;

public class ListCompare implements Comparator<String>{

    @Override
    public int compare(String o1, String o2) {
        int res = 0;
        for (int i = 0; i < o1.length() || i < o2.length(); i++) {
            if (i == (o1.length() - 1) && ((i + 1) == o2.length() - 1)) {
                res = -1;
                break;
            } else if (i == (o2.length() - 1) && ((i + 1) == o1.length() - 1)) {
                res = 1;
                break;
            }
            res = Character.compare(o1.charAt(i), o2.charAt(i));
            if (res != 0) {
                break;
            }
        }
        return res;
    }
}
