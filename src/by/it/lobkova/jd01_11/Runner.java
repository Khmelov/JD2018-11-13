package by.it.lobkova.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> list = new ListB<>();
        list.add("One");
        list.add("Two");
        list.add("33333");
        List<String> list2 = new ArrayList<>();
        list2.add("One232323");
        list2.add("Two232323");
        list2.add("33333232323");
        System.out.println(list);
        list.set(0, "hhh");
        list.addAll(list2);
        System.out.println(list);
    }
}
