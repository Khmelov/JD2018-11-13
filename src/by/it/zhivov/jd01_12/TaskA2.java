package by.it.zhivov.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TaskA2 {
    public static void main(String[] args) {
        Integer[] a = {1, 6, 8, 4, 5};
        Integer[] b = {2, 9, 7, 7, 0, 4, 5, 6};

        Set<Integer> hs = new HashSet<>(Arrays.asList(a));
        Set<Integer> ts = new TreeSet<>(Arrays.asList(b));

        System.out.println(hs + "\n" + ts);
        System.out.println(getCross(hs, ts));
        System.out.println(getUnion(hs, ts));
    }

    public static Set<Integer> getCross(Set<Integer> a, Set<Integer> b) {
        HashSet<Integer> res = new HashSet<>(a);
        res.retainAll(b);
        return res;
    }

    public static Set<Integer> getUnion(Set<Integer> a, Set<Integer> b) {
        HashSet<Integer> res = new HashSet<>(a);
        res.addAll(b);
        return res;
    }
}


