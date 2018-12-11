package by.it.kruglenja.jd01_11;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 06.12.2018.
 */
public class Runner {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("tree");
        System.out.println(list);
        list.remove(0);
        list.remove(1);
        System.out.println(list);
    }
}
