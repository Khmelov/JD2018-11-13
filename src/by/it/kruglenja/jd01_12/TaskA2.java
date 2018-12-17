package by.it.kruglenja.jd01_12;

import java.util.*;

/**
 * Created by user on 08.12.2018.
 */
public class TaskA2 {
    private static Set<Integer> getUnion(Set<Integer> one, Set<Integer> two) {
        Set<Integer> res = new HashSet<>(one);
        Iterator <Integer> iterator = two.iterator();
        while (iterator.hasNext()){
            res.add(iterator.next());
        }
        return res;
    }
    private static Set<Integer> getCross(Set<Integer> one, Set<Integer> two) {
        Set<Integer> res = new HashSet<>(one);
        Iterator <Integer> iterator = res.iterator();
        while (iterator.hasNext()){
            int element = iterator.next();
            if (!two.contains(element)){
                iterator.remove();
            }
        }
        return res;
    }
    public static void main(String[] args){
        TreeSet<Integer> treeSet = new TreeSet<>(Arrays.asList(1, 2, 3, 4, 4, 4, 5, 5, 6, 6));
        HashSet<Integer> hashSet = new HashSet<>(Arrays.asList(9, 8, 7, 4, 4, 4, 5, 5, 6, 6));
        System.out.println(getUnion(treeSet, hashSet));
        System.out.println(getCross(treeSet, hashSet));
    }
}
