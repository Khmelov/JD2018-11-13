package by.it._examples_.jd01_11.Collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

public class DemoTreeSet {
    public static void main(String[ ] args) {
        ArrayList<String> list = new ArrayList<>();
        boolean b;
        for (int i = 0; i < 6; i++) {
            list.add((int) (Math.random() * 10) + "Y ");
        }
        System.out.println(list + "список");
        TreeSet<String> set = new TreeSet(list);
        System.out.println(set + "множество");
        System.out.println(set.comparator()); // null – String реализует Comparable

        // извлечение наибольшего и наименьшего элементов
        System.out.println(set.last() + " " + set.first());
        HashSet<String> hSet = new HashSet<>(set);
        for (String str : hSet) {
            System.out.println(str + " " + str.hashCode());
        }
    }
}