package by.it.zakharenko.jd01_12;

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
        Integer[] dataA = {1, 2, 3, 4, 5, 6, 7, 7, 7, 7, 6, 5, 4, 3, 2, 1};
        Integer[] dataB = {4, 5, 6, 7, 7, 7, 8, 8, 9, 9, 0, 0, 0};
        Set<Integer> a = new HashSet<>(Arrays.asList(dataA));
        Set<Integer> b = new TreeSet<>(Arrays.asList(dataB));
        System.out.println(a + "\n" + b);
        System.out.println(getCross(a,b));
        System.out.println(getUnion(a,b));
    }
}
