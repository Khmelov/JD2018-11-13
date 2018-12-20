package by.it.denisova.jd01_12;

import java.util.*;

public class TaskA2 {


    public static Set<Integer> getCross(Set a, Set b) {
        Set<Integer> res = new HashSet<>(a);
        res.retainAll(b);
        return res;
    }

    public  static  Set<Integer> getUnion(Set a, Set b) {
        Set<Integer> result = new HashSet<>(a);
        result.addAll(b);
        return result;

    }

    public static void main(String[] args) {
        Integer[] dataA = {2,3,6,7,8,9,9,11,5};
        Integer[] dataB = {9,8,2,0,6,1,7,8,0,9,44};

        Set <Integer> a = new HashSet<>(Arrays.asList(dataA));
        Set <Integer> b = new TreeSet<>(Arrays.asList(dataB));

        System.out.println(a);
        System.out.println(b);
        System.out.println(getCross(a,b));
        System.out.println(getUnion(a,b));
    }
}
