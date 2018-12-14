package by.it.seroglazov.jd01_12;

import java.util.*;

public class TaskC2 {

    static Set<Number> getCross(Set<Number>... set){
        Set<Double> sd0 = new HashSet<>(set[0].size());
        set[0].forEach(x -> sd0.add(x.doubleValue())); // В sd0 Double версия нулевого Set аргумента
        Set<Number> finalSet = new HashSet<>(sd0);
        for (int i = 1; i < set.length; i++) {
            Set<Double> sd = new HashSet<>(set[i].size());
            set[i].forEach(x -> sd.add(x.doubleValue())); // Каждый Set аргумент переводим в Double версию
            finalSet.retainAll(sd);
        }
        return finalSet;
    }

    static Set<Number> getUnion(Set<Number>... set){
        Set<Double> sd0 = new HashSet<>(set[0].size());
        set[0].forEach(x -> sd0.add(x.doubleValue())); // В sd0 Double версия нулевого Set аргумента
        Set<Number> finalSet = new HashSet<>(sd0);
        for (int i = 1; i < set.length; i++) {
            Set<Double> sd = new HashSet<>(set[i].size());
            set[i].forEach(x -> sd.add(x.doubleValue())); // Каждый Set аргумент переводим в Double версию
            finalSet.addAll(sd);
        }
        return finalSet;
    }

    public static void main(String[] args) {
        Integer[] d1 = {1,  2,  3,  4,  5,      7         };
        Double[] d2 =  {    2d, 3d, 4d, 5d, 6d, 7d, 8d    };
        Long[] d3 =    {1L, 2L, 3L,             7L,     9L};
        Float[] d4 =   {    2f, 3f, 4f,         7f,     9f};
        Set<Number> s1 = new HashSet<>(Arrays.asList(d1));
        Set<Number> s2 = new TreeSet<>(Arrays.asList(d2));
        Set<Number> s3 = new HashSet<>(Arrays.asList(d3));
        Set<Number> s4 = new TreeSet<>(Arrays.asList(d4));
        System.out.println(getCross(s1, s2, s3, s4));
        System.out.println(getUnion(s1, s2, s3, s4));
    }
}