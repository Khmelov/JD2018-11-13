package by.it.lobkova.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TaskA2 {

    static Set<Integer> getCross(Set<Integer> a, Set<Integer> b) {
        HashSet<Integer> result = new HashSet<>(a);
        result.retainAll(b);
        return result;
    }

    static Set<Integer> getUnion(Set<Integer> a, Set<Integer> b) {
        HashSet<Integer> result = new HashSet<>(a);
        result.addAll(b);
        return result;

    }
    public static void main(String[] args) {
        Integer[] masA = {1, 2, 3, 4, 5, 6};
        Integer[] masB = {4, 5, 6, 7, 8, 9};

        Set<Integer> a = new  HashSet<>(Arrays.asList(masA));
        Set<Integer> b = new TreeSet<>(Arrays.asList(masB));

        System.out.println(a + "\n" + b);
        System.out.println(getCross(a, b));
        System.out.println(getUnion(a, b));
    }
}
