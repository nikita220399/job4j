package croc.task7_7;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class Number implements Runnable{


    private BestWorker log;
    public static Map<String, Integer> map = new HashMap<>();

    public Number(BestWorker log) {
        this.log = log;
    }

    public void getBest () {
        String best;
        int max = -1;
        for (int v : map.values()) {
            if (v > max) {
                max = v;
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (max == entry.getValue()) {
                best = entry.getKey();
                System.out.println(best);
                System.out.println(max);
                break;
            }
        }
    }

    @Override
    public void run() {
        try {
            log.bestWorker(map);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Number file1 = new Number(new BestWorker("C:\\Users\\Никита\\Desktop\\f1.txt"));
        Number file2 = new Number(new BestWorker("C:\\Users\\Никита\\Desktop\\f2.txt"));
        Number file3 = new Number(new BestWorker("C:\\Users\\Никита\\Desktop\\f3.txt"));
        Number file4 = new Number(new BestWorker("C:\\Users\\Никита\\Desktop\\f4.txt"));
        Number file5 = new Number(new BestWorker("C:\\Users\\Никита\\Desktop\\f5.txt"));
        Number file6 = new Number(new BestWorker("C:\\Users\\Никита\\Desktop\\f6.txt"));
        Number file7 = new Number(new BestWorker("C:\\Users\\Никита\\Desktop\\f7.txt"));
        Thread t1 = new Thread(file1);
        Thread t2 = new Thread(file2);
        Thread t3 = new Thread(file3);
        Thread t4 = new Thread(file4);
        Thread t5 = new Thread(file5);
        Thread t6 = new Thread(file6);
        Thread t7 = new Thread(file7);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();
        t6.join();
        t7.join();
        file1.getBest();
    }
}
