package by.it.burlakov.jd01_12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class TaskB3 {
    public static void main(String[] args) {
        String[] peoples = new String[4096];
        Arrays.fill(peoples, "NAME");

        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(peoples));
        LinkedList<String> linkedList = new LinkedList<>(Arrays.asList(peoples));
        LinkedList<String> linkedList2 = new LinkedList<>(Arrays.asList(peoples));

        long startArList = System.nanoTime();
        System.out.println(process(arrayList));
        long endArList = System.nanoTime();

        long startLinList1 = System.nanoTime();
        System.out.println(process(linkedList));
        long endLinList1 = System.nanoTime();

        long startLinList2 = System.nanoTime();
        System.out.println(process2(linkedList2));
        long endLinList2 = System.nanoTime();

        long deltaArList = (endArList - startArList) / 1000;
        long deltaLinList1 = (endLinList1 - startLinList1) / 1000;
        long deltaLinList2 = (endLinList2 - startLinList2) / 1000;

        System.out.println("ArrayList time = " + deltaArList);
        System.out.println("LinkedList1 time = " + deltaLinList1);
        System.out.println("LinkedList2 time = " + deltaLinList2);
    }

    static String process(ArrayList<String> peoples){
        int i = 1;
        while (peoples.size() > 1){
            for (Iterator<String> it = peoples.iterator(); it.hasNext();){ it.next();
                if (i % 2 == 0) { it.remove();}
                i++;
            }
        }
        return  peoples.get(0);
    }

    static String process(LinkedList<String> peoples){
        int i = 1;
        while (peoples.size() > 1){
            for (Iterator<String> it = peoples.iterator(); it.hasNext();){ it.next();
                if (i % 2 == 0) { it.remove();}
                i++;
            }
        }
        return  peoples.get(0);
    }

    //stack
    static String process2 (LinkedList<String> peoples){
//        LinkedList<String> copy = new LinkedList<>(peoples);

        String temp;
        while (peoples.size() > 1) {
            temp = peoples.pollFirst();
            peoples.removeFirst();
            peoples.addLast(temp);
        }
        return  peoples.get(0);
    }
}

