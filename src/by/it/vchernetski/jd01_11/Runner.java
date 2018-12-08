package by.it.vchernetski.jd01_11;

import java.util.*;

public class Runner {
    public static void main(String[] args) {
        Set<String> mySet = new SetC<>();
        Set<String> sEt = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            Integer s = new Integer(i*2);
            String s1 = s.toString();
            sEt.add(s1);
            mySet.add(s1);
        }
        System.out.println(mySet);
        System.out.println(sEt);
    }
}
