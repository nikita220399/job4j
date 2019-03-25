package croc.task4;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Reader {

    public static void main(String[] args) throws FileNotFoundException{
        String filename = args[0];
        try (Scanner scanner = new Scanner(new FileReader(filename))) {
            int words = 0;
            while (scanner.hasNextLine()) {
                char[] array = scanner.nextLine().toCharArray();
                boolean flag = false;
                boolean check = false;
                if (array[0] == ' ') {
                    words--;
                    check = true;
                }
                for (int i = 0; i < array.length; i++) {
                    if (array[i] == ' ') {
                        flag = true;
                    } else if (array[i] != ' ' && flag == true){
                        words++;
                        flag = false;
                    }
                    if (i == array.length - 1) {
                        words++;
                    }
                }
            }
            System.out.println("Number of words: " + words);
        }
    }
}
