package by.it.nickgrudnitsky.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TaskA2 {
    public static void main(String[] args) {
        Set<Integer> hashSet = new HashSet<>(Arrays.asList(1, 2, 4, 5, 2, 3, 6, 7, 3, 2, 3, 5));
        Set<Integer> treeSet = new TreeSet<>(Arrays.asList(1, 2, 4, 2, 3, 5, 2, 3, 4, 1, 23, 4));
        System.out.println(getUnion(hashSet, treeSet));
        System.out.println(getCross(hashSet, treeSet));
    }

    private static Set<Integer> getUnion(Set<Integer> a, Set<Integer> b) {
        Set<Integer> result = new HashSet<>(a);
        result.addAll(b);
        return result;
    }

    private static Set<Integer> getCross(Set<Integer> a, Set<Integer> b) {
        Set<Integer> result = new HashSet<>(a);
        result.retainAll(b);
        return result;
    }
}
