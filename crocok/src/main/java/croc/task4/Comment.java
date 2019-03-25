package croc.task4;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Comment {

    public static void main(String[] args) throws FileNotFoundException {
        String filename = args[0];
        try (Scanner scanner = new Scanner(new FileReader(filename))) {
            boolean flag = false;
            while (scanner.hasNextLine()) {
                boolean check = false;
                char[] array = scanner.nextLine().toCharArray();
                int index = 0;
                int jndex = 0;
                int count = 0;
                if (array[0] == '/' && array[1] == '*') {
                    flag = true;
                }
                if (array[0] == '/' && array[1] == '/') {
                    check = true;
                }
                List <Character> res = new ArrayList<>();
                for (int i = 0; i < array.length; i++) {
                    if (check == true) {
                        break;
                    }
                    if (i > 1) {
                        if (array[i - 1] == '/' && array[i] == '*') {
                            jndex = i - 1;
                            flag = true;
                            for (int k = index; k < jndex; k++, count++) {
                                res.add(array[k]);
                            }
                        }
                        if (flag == true && array[i - 1] == '*' && array[i] == '/') {
                            flag = false;
                            index = i + 1;
                        }
                        if (array[i - 1] == '/' && array[i] == '/' && flag == false) {
                            jndex = i - 1;
                            for (int k = index; k < jndex; k++, count++) {
                                res.add(array[k]);
                            }
                            for (Character c : res) {
                                System.out.print(c);
                            }
                            break;
                        }
                        if (i == array.length - 1 && flag == false) {
                            jndex = array.length;
                            for (int k = index; k < jndex; k++, count++) {
                                res.add(array[k]);
                            }
                            for (Character c : res) {
                                System.out.print(c);
                            }
                        }
                    }
                }
                System.out.println();
            }
        }
    }
}
