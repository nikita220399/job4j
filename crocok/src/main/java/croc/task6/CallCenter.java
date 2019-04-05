package croc.task6;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class CallCenter {

    public static void main(String[] args) throws FileNotFoundException {
        String filename = args[0];
        try (Scanner scanner = new Scanner(new FileReader(filename))) {
            Map<String, List<Integer>> map = new TreeMap<>();
            List<Integer> list = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String[] tokens = scanner.nextLine().split(",");
                int start = Integer.parseInt(tokens[0]);
                int end = Integer.parseInt(tokens[1]);
                int value = end - start;
                list.add(value);
                String name = tokens[2];
                if (map.containsKey(name)) {
                    map.get(name).add(start);
                    map.get(name).add(end);
                } else {
                    map.put(name, new ArrayList<>());
                    map.get(name).add(start);
                    map.get(name).add(end);
                }
            }
            Collections.sort(list);
            Collections.reverse(list);
            int flag = 0;
        A:  for (int check : list) {
                for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
                    List<Integer> array = entry.getValue();
                    for (int i = 0; i < array.size(); i += 2) {
                        int param1 = array.get(i);
                        int param2 = array.get(i + 1);
                        int dist = param2 - param1;
                        if (dist == check) {
                            flag++;
                            System.out.println(entry.getKey() + " , " + param1 + " , " + param2);
                            if (flag == 3) {
                                break A;
                            }
                        }
                    }
                }
            }
        }
    }
}
