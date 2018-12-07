package by.it.vchernetski.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> myList = new ListA<>();
        List<String> arList = new ArrayList<>();
        myList.add("one");
        myList.add("two");
        myList.add("four");
        arList.add("one");
        arList.add("two");
        arList.add("four");
        System.out.println("myList"+myList);
        System.out.println("arList"+arList);
        myList.add("three");
        arList.add("three");
        myList.remove("one");
        System.out.println(myList);
        System.out.println(myList.get(1));
    }
}
