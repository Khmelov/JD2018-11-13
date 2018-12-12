package by.it.malishevskiy.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> mylist = new ListA<>();
        List<String> arlist = new ArrayList<>();
        mylist.add("One"); arlist.add("One");
        mylist.add("Two"); arlist.add("Two");
        mylist.add("Four"); arlist.add("Four");
        System.out.println("mylist:" + mylist + "\narList:" + arlist);
        mylist.add(2, "Three"); arlist.add(2, "Three");
        mylist.add(0, "Start"); arlist.add(0, "Start");
        System.out.println("myList:" + mylist + "\narList:" + arlist);
        // Проверка удаления
        mylist.remove("Start"); arlist.remove("Start");
        mylist.remove(3); arlist.remove(3);
        System.out.println("myList:" + mylist + "\narList:" + arlist);
        // Проверка на чтение
        System.out.println("myList(0):" + mylist.get(0) + "\narList(0):" + arlist.get(0));
    }
}