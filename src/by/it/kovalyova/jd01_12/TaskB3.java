package by.it.kovalyova.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class TaskB3 {
    static String process(ArrayList<String> peoples) {
        boolean out = false;
        while (peoples.size() > 1) {
            ArrayList<String> toremove = new ArrayList<>();
            Iterator<String> it = peoples.iterator();
            while (it.hasNext()) {
                String s = it.next();
                if (out) {
                    out = false;
                    toremove.add(s);
                } else {
                    out = true;
                }
            }
            peoples.removeAll(toremove);
        }
        return peoples.get(0);
    }

    static String process(LinkedList<String> peoples) {
        boolean out = false;
        while (peoples.size() > 1) {
            //ArrayList<String> toremove = new ArrayList<>();
            Iterator<String> it = peoples.iterator();
            while (it.hasNext()) {
                String s = it.next();
                if (out) {
                    out = false;
                    it.remove();
                    //toremove.add(s);
                } else {
                    out = true;
                }
            }
            //peoples.removeAll(toremove);
        }
        return peoples.get(0);
    }

    public static void main(String[] args) {
        ArrayList<String> p1 = new ArrayList<>();
        LinkedList<String> p2 = new LinkedList<>();
        for (Integer i = 0; i < 4097; i++) {
            p1.add(i.toString());
            p2.add(i.toString());
        }
        long start = System.currentTimeMillis();
        System.out.println(process(p1));
        long stop = System.currentTimeMillis();
        System.out.println(stop-start);
        start = System.currentTimeMillis();
        System.out.println(process(p2));
        stop = System.currentTimeMillis();
        System.out.println(stop-start);
    }
}