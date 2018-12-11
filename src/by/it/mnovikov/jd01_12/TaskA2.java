package by.it.mnovikov.jd01_12;

import by.it.mnovikov.jd01_03.InOut;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by user on 08.12.2018.
 */
public class TaskA2 {

    static  Set<Integer> getUnion (Set<Integer> a, Set<Integer> b){
        HashSet<Integer> res = new HashSet<>(a);
        res.addAll(b);
        return res;
    }

    static  Set<Integer> getCross (Set<Integer> a, Set<Integer> b){
        HashSet<Integer> res = new HashSet<>(a);
        res.retainAll(b);
        return res;
    }

    public static void main(String[] args) {
        Integer[] dataA = {1, 2, 3, 4, 5, 6, 7, 7, 7 , 6, 5, 4, 3, 2, 1};
        Integer[] dataB = {4, 5, 6, 7, 7, 7, 8, 0, 1, 3, 9, 9, 0, 0, 0};
        Set<Integer> setA = new HashSet<>(Arrays.asList(dataA));
        Set<Integer> setB = new TreeSet<>(Arrays.asList(dataB));

        System.out.println(setA + "\n" + setB);
        getCross(setA, setB);
        getUnion(setA, setB);
        System.out.println(setA + "\n" + setB);


    }
}
