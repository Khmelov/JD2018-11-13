package by.it.burlakov.calc;

import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by user on 01.12.2018.
 */
class Printer {
    public void print (Var string){
        System.out.println(string);
    }
    public static void printvar() {
        Map<String, Var> tempMap = Var.getVarsMap();
        for (Map.Entry<String, Var> entry : tempMap.entrySet()) {
            String key = entry.getKey();
            Var value = entry.getValue();
            System.out.println(key + " = " + value);
        }
    }
    public static void sortvar() {
        Map<String, Var> tempMap = Var.getVarsMap();
        SortedSet<String> sortedSet = new TreeSet<>();
        sortedSet.addAll(tempMap.keySet());

        for (String key: sortedSet) {

            System.out.println(key + " = " + tempMap.get(key));
        }
    }

}
