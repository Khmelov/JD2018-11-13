package by.it.skarpovich.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> myList = new ListA<>();
        List<String> arList = new ArrayList<>();

        myList.add("First");
        arList.add("First");
        myList.add("Two");
        arList.add("Two");
        myList.add("Three");
        arList.add("Four");
        System.out.println("add myList:"+myList+"\narList:"+arList);
        myList.add(2, "Tree"); arList.add(2, "Tree");
        myList.add(0, "Start"); arList.add(0, "Start");
        System.out.println("add() myList:"+myList+"\narList:"+arList);

        myList.remove("Start"); arList.remove("Start");
        myList.remove(3);arList.remove(3);
        System.out.println("remove myList"+myList+"\narList:"+arList);
        System.out.println("get myList(0):"+myList.get(0)+"\narList(0):"+arList.get(0));
        System.out.println();

        List<String> myList2 = new ListB<>();
        List<String> arList2 = new ArrayList<>();

        myList2.add("First");
        arList2.add("First");
        myList2.add("Two");
        arList2.add("Two");
        myList2.add("Three");
        arList2.add("Four");
        System.out.println("add myList:"+myList2+"\narList:"+arList2);
        myList2.add(2, "Tree"); arList2.add(2, "Tree");
        myList2.add(0, "Start"); arList2.add(0, "Start");
        System.out.println("add() myList:"+myList2+"\narList:"+arList2);

        myList2.remove("Start"); arList2.remove("Start");
        myList2.remove(3);arList2.remove(3);
        System.out.println("remove myList"+myList2+"\narList:"+arList);
        System.out.println("get myList(0):"+myList2.get(0)+"\narList(0):"+arList2.get(0));


    }
}
