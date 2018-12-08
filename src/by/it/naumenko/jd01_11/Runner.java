package by.it.naumenko.jd01_11;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Runner {


    private static void taskA() {
        List<String> listList=new ArrayList<>();
        listList.add("First");
        listList.add("Two");
        listList.add("Threy");
        System.out.println(listList);
        listList.remove(2);
        System.out.println(listList);
        System.out.println(listList.get(1));


        List<String> myList = new ListA<>();
        myList.add("First");
        myList.add("Two");
        myList.add("Threy");
        System.out.println(myList);
        myList.remove(2);
        System.out.println(myList);
        System.out.println(myList.get(1));
    }


    private static void taskB() {
        List<String> listList=new ArrayList<>();
        listList.add("First");
        listList.add("Two");
        listList.add("Threy");
        System.out.println(listList);
        listList.remove(2);
        System.out.println(listList);
        System.out.println(listList.get(1));
        listList.add(0,"33333");
        System.out.println(listList);
        listList.addAll(listList);
        System.out.println(listList);
        System.out.println(listList.set(2, "three"));
        System.out.println(listList);


        System.out.println("---------------------------------");
        List<String> myList = new ListB<>();
        myList.add("First");
        myList.add("Two");
        myList.add("Threy");
        System.out.println(myList);
        myList.remove(2);
        System.out.println(myList);
        System.out.println(myList.get(1));
        myList.add(0,"33333");
        System.out.println(myList);
        myList.addAll(myList);
        System.out.println(myList);
        System.out.println(myList.set(3,"Threy"));
        System.out.println(myList);
//
    }

    private static void taskC(){
        Set<String> set = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        set.add("один");
        set.add("два");
        set.add("три");
        set.add("Один");
        System.out.println(set);

        set2.add("one");
        set2.add("two");

        System.out.println(set.size());
        System.out.println(set.isEmpty());

        set.addAll(set);
        System.out.println(set);

        System.out.println(set.contains("три"));
        System.out.println(set.containsAll(set2));

        set.remove("один");
        System.out.println(set);


        System.out.println("========================================");


        Set<String> set3 = new SetC<>();
        Set<String> set4 = new SetC<>();
        set3.add("пять");
        set3.add("шесть");
        set3.add("семь");
        set3.add("пять");
        System.out.println(set3);

        set4.add("five");
        set4.add("six");

        System.out.println(set3.size());
        System.out.println(set4.isEmpty());
        System.out.println(set4.size());
//
//        set3.addAll(set4);
//        System.out.println(set3);
//
        System.out.println(set3.contains("пять"));
//        System.out.println(set3.containsAll(set4));
        System.out.println(set3.remove("Шесть"));
        System.out.println(set3);


    }

    public static void main(String[] args) {
        //taskA();
        //taskB();
        taskC();

    }
}
