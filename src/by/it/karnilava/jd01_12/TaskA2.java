package by.it.karnilava.jd01_12;

import java.util.*;

public class TaskA2 {
    public static void main(String[] args) {
        HashSet<Integer> a = new HashSet<>(Arrays.asList(1,2,3,4,4,5,5,9,7,9));
        TreeSet<Integer> b = new TreeSet<>(Arrays.asList(1,8,3,4,6,6,5,9,6,9));


        System.out.println(a);
        System.out.println(b);
        System.out.println(getUnion(a, b));
        System.out.println(getCross(a, b));

    }

    private static Set<Integer> getCross(Set<Integer> one, Set<Integer> two) {
        Set<Integer>result=new HashSet<>(one);
        result.retainAll(two);
        return result;




    }

    private static Set<Integer> getUnion (Set<Integer> one, Set<Integer> two) {
        Set<Integer>result=new HashSet<>(one);
        result.addAll(two);
        return result;
    }
}
