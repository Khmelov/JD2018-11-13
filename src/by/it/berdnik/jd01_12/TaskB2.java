package by.it.berdnik.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class TaskB2 {
    static String process(ArrayList<String> human) {
        int count = 1;
        while (human.size() > 1) {
            Iterator<String> i = human.iterator();
            while (i.hasNext()) {
                i.next();
                if (count % 2 == 0) i.remove();
                count++;
            }
        }
        return human.get(human.size() - 1);
    }

    static String process(LinkedList<String> human) {
        int count = 1;
        while (human.size() > 1) {
            Iterator<String> i = human.iterator();
            while (i.hasNext()) {
                i.next();
                if (count % 2 == 0) i.remove();
                count++;
            }
        }
        return human.get(human.size() - 1);
    }

    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>();
        LinkedList<String> list2 = new LinkedList<>();
        for (int i = 1; i <= 100; i++) {
            list1.add("x" + i);
            list2.add("x" + i);
        }
        System.out.println(list1);
        System.out.println(list2);
        System.out.println(process(list1));
        System.out.println(process(list2));
    }
}
