package by.it.denisova.jd01_12;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TaskB1 {

    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        String word = scanner.next();
        while (scanner.hasNext()) {
            if (word.equalsIgnoreCase("end")) {
                break;
            }
            else {
                word = word.replace("[-.,?:;]","");

            }
            if (map.containsKey(word)) {
                map.put(word,map.get(word)+1);
            }
            else {
                map.put(word,1);
            }
            word = scanner.next();
        }
     /*
        while (!word.equalsIgnoreCase("end")){

            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            }
            else {
                map.put(word, 1);
            }
            word = scanner.next();
        }
        */
        System.out.println(map);

    }
}
