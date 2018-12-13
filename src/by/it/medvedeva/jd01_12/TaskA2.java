package by.it.medvedeva.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TaskA2 {


    public static Set<Integer> getUnion(Set<Integer> one, Set<Integer> two) {
        Set<Integer> result=new HashSet<>(one);
        result.addAll(two);
        return result;
    }

    public static Set<Integer> getCross(Set<Integer> one, Set<Integer> two) {
        Set<Integer> result=new HashSet<>(one);
        result.retainAll(two);
        return result;
    }
    public static void main(String[] args) {
        TreeSet<Integer> treeSet=new TreeSet<>(Arrays.asList(1,2,3,4,5,6,7,7,7,7,6,5,4,3,2,1));
        HashSet<Integer> hashSet= new HashSet<>(Arrays.asList(4,5,6,7,7,7,8,8,9,9,0,0,0));
        System.out.println(getUnion(treeSet,hashSet));
        System.out.println(getCross(treeSet,hashSet));
    }
}