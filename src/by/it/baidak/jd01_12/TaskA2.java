package by.it.baidak.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by user on 08.12.2018.
 */
public class TaskA2 {

    static Set<Integer> getCross(Set<Integer> a, Set<Integer> b){
        HashSet<Integer> set = new HashSet<>();
        for (Integer integer : a) {
            if(b.contains(integer)) set.add(integer);
        }
        return set;
    }

    static Set<Integer> getUnion(Set<Integer> a, Set<Integer> b){
        HashSet<Integer> set = new HashSet<>(a);
        set.addAll(b);
        return set;
    }

    public static void main(String[] args) {

        Integer[] dataA = {0,2,4,65,21,2,2,2,4,5,1,2,4,5,6};
        Integer[] dataB = {0,2,4,65,21,2,2,2,4,5,1,2};

        Set<Integer> a = new HashSet<>(Arrays.asList(dataA));
        Set<Integer> b = new TreeSet<>(Arrays.asList(dataA));
    }
}
