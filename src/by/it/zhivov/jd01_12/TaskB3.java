package by.it.zhivov.jd01_12;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class TaskB3 {
    public static void main(String[] args) {

        ArrayList<String> arrList = new ArrayList<>();
        for (int i = 1; i <= 4096; i++) {
            arrList.add(Integer.toString(i));
        }
        long start = System.nanoTime();
        process(arrList);
        long finish = System.nanoTime();
        System.out.println(finish-start);

        LinkedList<String> linkList = new LinkedList<>();
        linkList.addAll(arrList);

        start = System.nanoTime();
        process(linkList);
        finish = System.nanoTime();
        System.out.println(finish-start);

    }


    static String process(ArrayList<String> peoples) {
        peoples.trimToSize();
        int count = 0;
        Iterator<String> it;
        while (peoples.size() != 1) {
            it = peoples.iterator();
            while (it.hasNext()) {
                it.next();
                count++;
                if (count % 2 == 0) it.remove();
            }
        }
        return peoples.get(0);
    }


    static String process(LinkedList<String> peoples) {
        int count = 0;
        Iterator<String> it;
        while (peoples.size() != 1) {
            it = peoples.iterator();
            while (it.hasNext()) {
                it.next();
                count++;
                if (count % 2 == 0) it.remove();
            }
        }
        return peoples.get(0);
    }
}

