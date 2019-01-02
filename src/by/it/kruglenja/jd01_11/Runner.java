package by.it.kruglenja.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
//        List<String> myList = new ListB();
//        List<String> arList = new ArrayList<>();
//        List<String> addList = new ArrayList<>();
//        addList.add("1001");
//        addList.add("1002");
//        addList.add("1003");
//        addList.add("1004");
////        myList.addAll(addList);
//
//        myList.add("One");arList.add("One");
//        myList.add("Two");arList.add("Two");
//        myList.add("Tree");arList.add("Tree");
//
//        System.out.println("myList: " + myList + "\n arList: " + arList);
//
//        myList.add(2,"Fifty");arList.add(2,"Fifty");
//        myList.add(0,"FiftySeven");arList.add(0,"FiftySeven");
//
//        System.out.println("myList: " + myList + "\n arList: " + arList);
//
//        myList.remove("One");arList.remove("One");
//        myList.remove(3);arList.remove(3);
//
//        System.out.println("myList: " + myList + "\n arList: " + arList);
//
//        System.out.println("myList(0): " + myList.get(0) + "\n arList(0): " + arList.get(0));

        SetC<Integer> s = new SetC<>();
        s.add(1);
        s.add(2);
        s.add(3);
        s.add(4);
        s.add(1);
        s.add(5);
        s.add(6);
        s.add(7);
        s.add(8);
        System.out.println(s);
        s.remove(5);
        s.remove(9);
        System.out.println(s);

        ArrayList<Integer> lb = new ArrayList<>();
        lb.add(1);
        lb.add(2);
        lb.add(7);
        lb.add(22);
        System.out.println(lb);
        System.out.println(s.containsAll(lb));
        System.out.println(s.removeAll(lb));
        System.out.println(s);
        s.add(0);
        s.add(2);
        s.add(7);
        s.add(16);
        System.out.println(s);
        System.out.println(s.containsAll(lb));
    }
}
