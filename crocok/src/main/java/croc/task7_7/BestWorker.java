package croc.task7_7;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;
import java.util.Scanner;

public class BestWorker {

    private String filename;

    public BestWorker(String filename) {
        this.filename = filename;
    }

    public void bestWorker(Map<String, Integer> map) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new FileReader(filename))) {
            while (scanner.hasNextLine()) {
                String[] tokens = scanner.nextLine().split(",");
                String name = tokens[2];
                if (map.containsKey(name)) {
                    map.put(name, map.get(name) + 1);
                } else {
                    map.put(name, 1);
                }
            }
        }
    }
}
