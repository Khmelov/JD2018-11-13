package by.it.vchernetski.jd01_12;

import java.util.*;

public class TaskB3 {
    static String process(ArrayList<String> peoples) {
        int count = 1;
        while (peoples.size() > 1) {
            Iterator<String> i = peoples.iterator();
            while (i.hasNext()) {
                i.next();
                if (count % 2 == 0) i.remove();
                count++;
            }
            peoples.trimToSize();
        }
        return peoples.get(peoples.size() - 1);
    }

    static String process(LinkedList<String> peoples) {
        int count = 1;
        while (peoples.size() > 1) {
            Iterator<String> i = peoples.iterator();
            while (i.hasNext()) {
                i.next();
                if (count % 2 == 0) i.remove();
                count++;
            }
        }
        return peoples.get(peoples.size() - 1);
    }
    static String process(Deque<String> peoples) {
        int count = 1;
        while (peoples.size() > 1) {
            Iterator<String> i = peoples.iterator();
            while (i.hasNext()) {
                i.next();
                if (count % 2 == 0) i.remove();
                count++;
            }
        }
        return peoples.getFirst();
    }
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>();
        LinkedList<String> list2 = new LinkedList<>();
        Deque<String> deq = new ArrayDeque<>(list2);
        for (int i = 1; i <= 4096; i++) {
            list1.add("n" + i);
            list2.add("n" + i);
            deq.add("n"+i);
        }
        System.out.println(deq.getFirst());
        System.out.println(deq);
        System.out.println(list1);
        System.out.println(list2);
        long time1 = System.nanoTime();
        System.out.println(process(list1));
        time1 = (System.nanoTime()-time1)/1000;
        long time2 = System.nanoTime();
        System.out.println(process(list2));
        time2 = (System.nanoTime()-time2)/1000;
        long time3 = System.nanoTime();
        System.out.println(process(deq));
        time3 = (System.nanoTime()-time3)/1000;
        System.out.println(time1+"\t"+time2+"\t"+time3);
    }
}
