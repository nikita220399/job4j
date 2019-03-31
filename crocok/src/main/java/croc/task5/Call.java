package croc.task5;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Call {

    public static void main(String[] args) throws FileNotFoundException {
        String filename = args[0];
        try (Scanner scanner = new Scanner(new FileReader(filename))) {
            Map<String, Integer> map = new HashMap<>();
            int kolvoKey = 0;
            int sum = 0;
            while (scanner.hasNextLine()) {
                String[] tokens = scanner.nextLine().split(",");
                int start = Integer.parseInt(tokens[0]);
                int end = Integer.parseInt(tokens[1]);
                int value = end - start;
                String name = tokens[2];
                if (map.containsKey(name)) {
                    map.put(name, map.get(name) + value);
                } else {
                    map.put(name, value);
                    kolvoKey++;
                }
            }
            for (int v : map.values()) {
                sum += v;
            }
            System.out.println(sum/kolvoKey);
        }
    }
}
