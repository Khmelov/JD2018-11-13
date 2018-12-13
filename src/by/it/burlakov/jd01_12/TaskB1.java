package by.it.burlakov.jd01_12;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> map = new TreeMap<>();
        String line;
        int count;

        Pattern pattern = Pattern.compile("[a-zA-z]*[']?[a-zA-Z]*");

        while(!(line = scanner.nextLine()).equalsIgnoreCase("end")){

            Matcher matcher = pattern.matcher(line);

            while(matcher.find()){
                String word = matcher.group();
                if (!map.containsKey(word)){
                    map.put(word, 1);
                }
                else {
                    count = map.get(word);
                    map.put(word, ++count);
                }

            }
        }
        System.out.println(map.toString());
    }
}