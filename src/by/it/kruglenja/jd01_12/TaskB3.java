package by.it.kruglenja.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by user on 11.12.2018.
 */
public class TaskB3 {
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
}
