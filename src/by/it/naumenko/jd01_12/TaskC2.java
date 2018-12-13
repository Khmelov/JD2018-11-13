package by.it.naumenko.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TaskC2 {
    public static void main(String[] args) {
        Integer[] dataA = new Integer[]{1, 2, 3, 4, 5, 6, 7, 7, 6, 5, 4, 3, 2, 1};
        Integer[] dataB = new Integer[]{11, 22, 33, 44, 55, 6, 7, 4, 3, 2, 1};
        Integer[] dataC = new Integer[]{11, 22, 33, 44, 55, 666, 777, 3, 2, 1};
        Set<?> a = new HashSet<>(Arrays.asList(dataA));
        Set<?> b = new TreeSet<>(Arrays.asList(dataB));
        Set<?> c = new TreeSet<>(Arrays.asList(dataC));
        System.out.println(a + "\n" + b + "\n" + c);
        System.out.println(getCross(a, b, c));
       // System.out.println(getUnion(a, b, c));
    }

    private static Set<Double> toDouble(Set<?> set){
        HashSet<Double> rezultat = new HashSet<>();
        for (Object o : set) {
            rezultat.add(Double.parseDouble(o.toString()));
        }
        return rezultat;
    }

    private static Set<?> getCross(Set<?>... a) {
        HashSet<?> rezultat = new HashSet<>(a[0]);
        for (Set<?> set : a) {
            rezultat.retainAll(set);
        }
        return rezultat;
    }

//    private static Set<Double> getUnion(Set<?>... a) {
//        HashSet<Double> rezultat = new HashSet<>();
//        for (Set<?> set1 : a) {
//            Set<?> buf = toDouble(set1);
//            rezultat.addAll(buf);
//        }
//        return  rezultat;
//    }


}
