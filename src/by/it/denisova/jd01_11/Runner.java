package by.it.denisova.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> myList = new ListA<>();
        List<String> list = new ArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("33333");
        System.out.println(list);
        list.remove("33333");
        System.out.println(list);

        myList.add("One");
        myList.add("Two");
        myList.add("33333");
        System.out.println(myList);
        myList.remove("33333");
        System.out.println(myList);
    }
}
