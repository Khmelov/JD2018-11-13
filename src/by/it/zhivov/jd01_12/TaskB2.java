package by.it.zhivov.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class TaskB2 {
    public static void main(String[] args) {
        ArrayList<String> arrList = new ArrayList<>();
        arrList.add("1");
        arrList.add("2");
        arrList.add("3");
        arrList.add("4");
        arrList.add("5");
        arrList.add("6");
        arrList.add("7");
        System.out.println(process(arrList));

        LinkedList<String> linkList = new LinkedList<>();
        linkList.addAll(arrList);
        System.out.println(process(linkList));
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



