package by.it.vchernetski.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TaskA2 {
    private static Set <Integer> getUnion(Set <Integer> one, Set <Integer> two){
        Set<Integer> res = new HashSet<>(one);
        res.addAll(two);
        return res;
    }
    private static Set <Integer> getCross(Set <Integer> one, Set <Integer> two){
        Set<Integer> res = new HashSet<>(one);
        res.retainAll(two);
        return res;
    }
    public static void main(String[] args) {
        TreeSet<Integer> treeset = new TreeSet<>(Arrays.asList(1,2,3,4,12,1,3,5,12,3,1));
        HashSet<Integer> set = new HashSet<>(Arrays.asList(9,9,2,4,12,6,23,4));
        System.out.println(getUnion(treeset,set));
        System.out.println(getCross(treeset,set));
    }
}
