package by.it.kruglenja.jd01_12;

import by.it.vchernetski.jd01_04.TaskB;

import java.util.*;

public class TaskB2 {
    static String process(ArrayList<String> peoples){
        int i = 1;
        while (peoples.size() > 1){
            for (Iterator<String> iterator = peoples.iterator(); iterator.hasNext();) {
                iterator.next();
                if (i % 2 == 0) {
                    iterator.remove();
                }
                i++;
            }
        }
        return  peoples.get(0);
    }
    static String process(LinkedList<String> peoples){
        int i = 1;
        while (peoples.size() > 1){
            Iterator<String> iterator = peoples.iterator();
            while(iterator.hasNext()){
                iterator.next();
                if (i % 2 == 0) {
                    iterator.remove();
                }
                i++;
            }
        }
        return  peoples.get(0);
    }
    public static void main(String[] args) {
        String[] arr = {"L1", "R1", "L2"};
        ArrayList<String> peoples1 = new ArrayList<>(Arrays.asList(arr));
        LinkedList<String> peoples2 = new LinkedList<>(Arrays.asList(arr));

        System.out.println(process(peoples1));
        System.out.println(process(peoples2));
    }
}
