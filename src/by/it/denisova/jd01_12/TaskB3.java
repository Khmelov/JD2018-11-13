package by.it.denisova.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class TaskB3 {
    public static void main(String[] args) {
        ArrayList<String> peoples1 = new ArrayList<>();

        System.out.println(peoples1 + " ArrayList");
        for (int i = 1; i <= 4096; i++) {
            peoples1.add(Integer.toString(i));
        }
        long start = System.nanoTime();
        process(peoples1);
        long finish = System.nanoTime();
        System.out.println(start-finish);

        //проверка для linkedList
        LinkedList<String> peoples2 = new LinkedList<>();
        peoples2.addAll(peoples1);
        long start2 = System.nanoTime();
        process(peoples2);
        long finish2 = System.nanoTime();
        System.out.println(start2-finish2);
    }

    public static String process(ArrayList<String> peoples) {
        peoples.trimToSize();
        double col= 0;
        Iterator<String> iter;
        while (peoples.size()!=1) {
            iter = peoples.iterator();
            while (iter.hasNext()) {
                iter.next();
                col++;
                if (col % 2 ==0 ) iter.remove();
            }
        }
        return peoples.get(0);
    }

    public static String process(LinkedList<String> peoples) {
        double col= 0;
        Iterator<String> iter;
        while (peoples.size()!=1) {
            iter = peoples.iterator();
            while (iter.hasNext()) {
                iter.next();
                col++;
                if (col % 2 ==0 ) iter.remove();
            }
        }
        return peoples.get(0);
    }
}
