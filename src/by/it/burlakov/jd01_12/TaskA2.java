package by.it.burlakov.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
        Integer[] dataA = {1, 3, 5, 6, 7};
        Integer[] dataB = {1, 2, 5, 6, 7, 9, 8};
        Set<Integer> a = new HashSet<>(Arrays.asList(dataA));
        Set<Integer> b = new HashSet<>(Arrays.asList(dataB));
        System.out.println(a + " " + b);
        System.out.println(getCross(a, b));
        System.out.println(getUnion(a, b));
    }
}
