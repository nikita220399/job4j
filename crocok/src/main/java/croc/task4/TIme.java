package croc.task4;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TIme {

    public static void main(String[] args) throws FileNotFoundException {
        String filename = args[0];
        int res = 0;
        try (Scanner scanner = new Scanner(new FileReader(filename))) {
            List<String[]> list = new ArrayList<>();
            while (scanner.hasNextLine()) {
                list.add(scanner.nextLine().split(","));
            }
            for (String[] a1 : list) {
                int count = 0;
                int index = Integer.parseInt(a1[0]);
                int jndex = Integer.parseInt(a1[1]);
                for (String[] a2 : list) {
                    int i = Integer.parseInt(a2[0]);
                    int j = Integer.parseInt(a2[1]);
                    if (index <= i && jndex >= j) {
                        count++;
                    }
                }
                if (count > res) {
                    res = count;
                }
            }
        }
        System.out.println(res);
    }
}
