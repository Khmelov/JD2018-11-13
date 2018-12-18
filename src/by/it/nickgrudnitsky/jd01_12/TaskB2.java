package by.it.nickgrudnitsky.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class TaskB2 {
    private static String process(ArrayList<String> peoples) {

        int counter = 0;
        while (peoples.size() > 1) {
            Iterator<String> iterator = peoples.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                counter++;
                if (counter % 2 == 0) {
                    iterator.remove();
                }
            }
        }
        return peoples.get(0);
    }

    private static String process(LinkedList<String> peoples) {
        int counter = 0;
        while (peoples.size() > 1) {
            Iterator<String> iterator = peoples.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                counter++;
                if (counter % 2 == 0) {
                    iterator.remove();
                }
            }
        }
        return peoples.get(0);
    }

    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        LinkedList<String> linkedList = new LinkedList<>();
        for (int i = 1; i <= 10; i++) {
            arrayList.add("n" + i);
            linkedList.add("n" + i);
        }
        System.out.println(arrayList);
        System.out.println(process(arrayList));
        System.out.println(linkedList);
        System.out.println(process(linkedList));
    }
}
