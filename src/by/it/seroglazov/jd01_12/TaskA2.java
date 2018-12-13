package by.it.seroglazov.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TaskA2 {


    static Set<Integer> getCross(Set<Integer> s1, Set<Integer> s2){
        Set<Integer> s = new HashSet<>(s1);
        s.retainAll(s2);
        return s;
    }

    static Set<Integer> getUnion(Set<Integer> s1, Set<Integer> s2){
        Set<Integer> s = new HashSet<>(s1);
        s.addAll(s2);
        return s;
    }

    public static void main(String[] args) {
        Integer[] d1 = {1, 2, 3, 5, 7};
        Integer[] d2 = {0, 2, 6, 8, 5, 12, 2};
        Set<Integer> a = new HashSet<>(Arrays.asList(d1));
        Set<Integer> b = new TreeSet<>(Arrays.asList(d2));
        System.out.println(getCross(a, b));
        System.out.println(getUnion(a, b));
    }
}
