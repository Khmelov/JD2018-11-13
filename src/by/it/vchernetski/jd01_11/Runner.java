package by.it.vchernetski.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> myList = new ListB<>();
        List<String> arList = new ArrayList<>();
        arList.add("one");
        arList.add("two");
        arList.add("four");
        myList.add("one");
        myList.add("two");
        myList.add("four");
        System.out.println(myList);
        System.out.println(arList);
        myList.addAll(arList);
        System.out.println(myList);
    }
}
