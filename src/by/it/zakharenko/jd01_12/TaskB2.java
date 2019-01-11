package by.it.zakharenko.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TaskB2 {

    private static String processCommon(List<String> peoples){
        Iterator<String> it = peoples.iterator();
        int c = 1;
        while (true) {
            if (it.hasNext()) {
                it.next();
                if (c++ % 2 == 0) it.remove();
            } else {
                if (peoples.size() == 1) return peoples.get(0);
                else it = peoples.iterator();
            }
        }
    }

    static String process(ArrayList<String> peoples) {
        return processCommon(peoples);
    }

    static String process(LinkedList<String> peoples) {
        return processCommon(peoples);
    }

    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<>();
        LinkedList<String> list = new LinkedList<>();
        for (int i = 1; i <= 20; i++) {
            arr.add("n" + i);
            list.add("n" + i);
        }
        System.out.println(process(arr));
        System.out.println(process(list));


    }

}
