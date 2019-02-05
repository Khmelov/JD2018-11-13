package by.it.zakharenko.jd01_11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Runner {
    public static void main(String[] args) {
        List<String> myList = new ListA<>();
        List<String> myList1 = new ListB<>();
        List<String> myList2 = new ListB<>();
        List<String> arrList = new ArrayList<>();
        List<String> arrList2 = new ArrayList<>();
        Set<String> standartHashSet = new HashSet<>();
        Set<String> mySet = new SetC<>();

        taskA(myList, arrList);
        taskB(myList1, myList2, arrList, arrList2);
        taskC(standartHashSet, mySet);
    }

    private static void taskC(Set<String> standartHashSet, Set<String> mySet) {
        standartHashSet.add("One");
        standartHashSet.add("Two");
        standartHashSet.add("Three");
        standartHashSet.add("Four");
        System.out.println(standartHashSet);
        List<String> added = new ArrayList<>();
        added.add(null);
        added.add(null);
        added.add("FFF");
        added.add("FFF");
        added.add("FFF1");
        added.add("FFF2");
        standartHashSet.addAll(added);
        System.out.println(standartHashSet);
        System.out.println(standartHashSet.containsAll(added));

        mySet.add("One");
        mySet.add("Two");
        mySet.add("Three");
        mySet.add("Four");
        System.out.println(mySet);
        mySet.addAll(added);
        System.out.println(mySet);
        System.out.println(mySet.containsAll(added));
    }

    private static void taskB(List<String> myList, List<String> myList2, List<String> arrList, List<String> arrList2) {
        arrList2.add("one");
        arrList2.add("two");
        myList2.add("one");
        myList2.add("two");

        arrList.add("One");
        arrList.add("Two");
        arrList.add("Three");
        arrList.set(0, "Five");
        System.out.println(arrList);
        arrList.addAll(arrList2);
        System.out.println(arrList);

        myList.add("One");
        myList.add("Two");
        myList.add("Three");
        myList.set(0, "Five");
        System.out.println(myList);
        myList.addAll(myList2);
        System.out.println(myList);
    }

    private static void taskA(List<String> myList, List<String> arrList) {
        arrList.add("One");
        arrList.add("Two");
        arrList.add("Three");
        arrList.add(1, "Four");
        System.out.println(arrList);
        System.out.println(arrList.get(1));
        arrList.remove("Two");
        arrList.remove(0);
        System.out.println(arrList);


        myList.add("One");
        myList.add("Two");
        myList.add("Three");
        myList.add(1, "Four");
        System.out.println(myList);
        System.out.println(myList.get(1));
        myList.remove("Two");
        myList.remove(0);
        System.out.println(myList);
    }
}
