package by.it.kovalyova.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class TaskB2 {
    static String process(ArrayList<String> peoples) {
        boolean out = false;
        while (peoples.size()>1){
            ArrayList<String> toremove = new ArrayList<>();
            Iterator<String> it = peoples.iterator();
            while(it.hasNext()) {
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
        while (peoples.size()>1){
            ArrayList<String> toremove = new ArrayList<>();
            Iterator<String> it = peoples.iterator();
            while(it.hasNext()) {
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

    public static void main(String[] args) {
        String[] names = new String[] {"Tinker","Tailor","Soldier","Sailor","Rich Man","Poor man","Beggar man","Thief","Spy"};
        ArrayList<String> p1 = new ArrayList<>();
        LinkedList<String> p2 = new LinkedList<>();
        for (String n: names) {
            p1.add(n);
            p2.add(n);
        }
        System.out.println(process(p1));
        System.out.println(process(p2));
    }
}
