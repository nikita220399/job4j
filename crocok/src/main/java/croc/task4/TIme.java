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
                int count = 1;
                int index = Integer.parseInt(a1[0]);
                int jndex = Integer.parseInt(a1[1]);

                for (String[] a2 : list) {
                    int i = Integer.parseInt(a2[0]);
                    int j = Integer.parseInt(a2[1]);
                    boolean change = false;
                    if (i == index && j == jndex && list.indexOf(a2) != list.indexOf(a1)) {
                        change = true;
                    }

                    if ((index <= i && jndex >= j && (i != index || j != jndex)) || change == true) {
                        if (change == false) {
                            count++;
                        }
                        int check = count;
                        for (String[] a3 : list) {
                            int k1 = Integer.parseInt(a3[0]);
                            int k2 = Integer.parseInt(a3[1]);
                            if (((k1 != i || k2 != j) && (i <= k1 && j >= k1) && (k1 != index || k2 != jndex) && (k1 != j))) {
                                check++;
                            }
                        }
                        boolean flag = false;
                        for (String[] a4 : list) {
                            int k11 = Integer.parseInt(a4[0]);
                            int k22 = Integer.parseInt(a4[1]);

                            if (k11 == i && k22 == j) {
                                check++;
                            }
                            if (flag == false) {
                                check--;
                                flag = true;
                            }
                        }
                        if (check > res) {
                            res = check;
                        }
                    }
                    count = 1;
                }
                if (count > res) {
                    res = count;
                }
            }
        }
        System.out.println(res);
    }
}
