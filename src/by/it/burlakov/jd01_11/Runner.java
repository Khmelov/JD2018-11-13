package by.it.burlakov.jd01_11;

import java.util.*;

/**
 * Created by user on 06.12.2018.
 */
public class Runner {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("333");
        System.out.println(list);
        list.remove(1);
        System.out.println(list);

        List<String> list2 = new ListA<>();
        list2.add("one");
        list2.add("two");
        list2.add("333");
        System.out.println(list2);
        list2.remove(1);
        System.out.println(list2);

        List<String> list3 = new ListB<>();
        list3.add("on12e");
        list3.add("t23o");
        list3.add("333");
        System.out.println(list3);
        list3.remove(1);
        System.out.println(list3);
        System.out.println(list3.isEmpty());
        list3.clear();
        list3.add("11111");
        System.out.println(list3);

        Set<String> setMain = new HashSet<>();

        setMain.add("one");
        setMain.add("two");
        setMain.add("232123");

        System.out.println(setMain);
        System.out.println(setMain.isEmpty());


        Set<String> set2 = new SetC<>();
        set2.add("one");
        set2.add("two");
        set2.add("232123");

        Set<String> set3 = new SetC<>();
        set3.add("two");
        set3.add("4444");
        set3.add("55555");
        set3.add("4444");
        System.out.println(set3);
        set2.addAll(set3);
        System.out.println(set2);
        set2.removeAll(set3);
        System.out.println(set2);
        set2.clear();
        System.out.println(set2);

    }
}
