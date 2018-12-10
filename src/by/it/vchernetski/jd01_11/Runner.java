package by.it.vchernetski.jd01_11;

import java.util.*;

public class Runner {
    public static void main(String[] args) {
        Set<String> mySet = new SetC<>();
        Set<String> sEt = new HashSet<>();
        System.out.println(mySet.add("1"));
        System.out.println(mySet.add("2"));
        System.out.println(mySet.remove("3"));
        System.out.println(mySet);
    }
}
