package by.it.naumenko.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TaskA2 {
    public static void main(String[] args) {
        Integer[] dataA = new Integer[]{1, 2, 3, 4, 5, 6, 7, 7, 6, 5, 4, 3, 2, 1};
        Integer[] dataB = new Integer[]{11, 22, 33, 44, 55, 6, 7, 4, 3, 2, 1};
        Set<Integer> a = new HashSet<>(Arrays.asList(dataA));
        Set<Integer> b = new TreeSet<>(Arrays.asList(dataB));
        System.out.println(a + "\n" + b);
        System.out.println(getCross(a, b));
        System.out.println(getUnion(a, b));
    }

    private static Set<Integer> getCross(Set<Integer> a, Set<Integer> b) {
        HashSet<Integer> rezultat=new HashSet<>(a);
        rezultat.retainAll(b);
        return rezultat;
    }

    private static Set<Integer> getUnion(Set<Integer> a, Set<Integer> b) {
        HashSet<Integer> reultat = new HashSet<>(a);
        reultat.addAll(b);
        return reultat;
    }


}
