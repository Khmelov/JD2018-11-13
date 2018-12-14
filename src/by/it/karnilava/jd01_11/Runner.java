package by.it.karnilava.jd01_11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Runner {
    public static void main(String[] args) {
        List <String> myList = new ListB<>();
        List<String> arList = new ArrayList<>();
        Set<Integer> hashSet = new HashSet<>();
        myList.add("One"); arList.add("One");
        myList.add("Two"); arList.add("Two");
        myList.add("6692"); arList.add("6692");
        myList.remove(1);
        myList.set(0, "2");
        Set <String> mySet = new SetC<>();
        mySet.add("SetOne");
        mySet.add("SetOne");
        mySet.add("Set2");
        mySet.add("Set453434ne");
        hashSet.add(9);
        hashSet.add(8798798);
        hashSet.add(6786);




        System.out.println(myList);
        System.out.println(arList);
        System.out.println(myList.get(0));
        System.out.println(mySet);
        System.out.println(hashSet);
        System.out.println();
        System.out.println( hashSet.toString());
        System.out.println(mySet.remove("Set2"));

    }



}
