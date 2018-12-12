package by.it.berdnik.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
//        List<String> myList = new ListA<>();
        List<String> myList = new ListB<>();
        List<String> arList = new ArrayList<>();

        myList.add("First"); arList.add("First");
        myList.add("Two"); arList.add("Two");
        myList.add("Four"); arList.add("Four");
        System.out.println("add myList:" + myList + "\narList:" + arList);
        myList.add(2, "Tree"); arList.add(2, "Tree");
        myList.add(0, "Start"); arList.add(0, "Start");
        System.out.println("add() myList:" + myList + "\narList:" + arList);

        myList.remove("Start"); arList.remove("Start");
        myList.remove(3); arList.remove(3);
        System.out.println("remove myList:" + myList + "\narList:" + arList);

        System.out.println("get myList(0):" + myList.get(0) + "\narList(0):" + arList.get(0));
    }
}
