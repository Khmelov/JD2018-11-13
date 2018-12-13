package by.it.vchernetski.jd01_12;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TaskC2 {
    private static Set<Double> todouble(Set<?> a){
        Set<Double> set = new TreeSet<>();
        for (Object s: a) {
            set.add(Double.parseDouble(s.toString()));
        }
        return set;
    }
    private static Set <Double> getUnion(Set <?>... mas){
        Set<Double> res = new TreeSet<>();
        for (Set<?> ma : mas) {
            Set<Double> temp = todouble(ma);
            res.addAll(temp);
        }
        return res;
    }
    private static Set <Double> getCross(Set <?>... mas){
        Set<Double> res = new TreeSet<>(todouble(mas[0]));
        for (Set<?> ma : mas) {
            Set<Double> temp = todouble(ma);
            res.retainAll(temp);
        }
        return res;
    }
    public static void main(String[] args) {
        Integer[] mas1 = {1,2,3};
        Double[] mas2 = {1.0, 4.0, 3.0, 2.0, 4.1};
        Short[] mas3 = {1,2,5,3,67};
        HashSet<Integer> set1 = new HashSet<>(Arrays.asList(mas1));
        HashSet<Double> set2 = new HashSet<>(Arrays.asList(mas2));
        HashSet<Short> set3 = new HashSet<>(Arrays.asList(mas3));
        System.out.println(getUnion(set1,set2,set3));
        System.out.println(getCross(set1,set2,set3));
    }
}
