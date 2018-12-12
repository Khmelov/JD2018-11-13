package by.it.mnovikov.jd01_11;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 06.12.2018.
 */
public class Runner {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("333333");
        System.out.println(list);
        list.remove("333333");
        System.out.println(list);


        List<String> list2 = new ArrayList<>();
        list2.add("one");
        list2.add("two");
        list2.add("333333");
        System.out.println(list2);
        list2.remove("333333");
        System.out.println(list2);
    }
}


