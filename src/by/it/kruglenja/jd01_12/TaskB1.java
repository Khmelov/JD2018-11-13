package by.it.kruglenja.jd01_12;

import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = "";
        TreeMap<String, Integer> result = new TreeMap<>();
        Pattern pattern = Pattern.compile("[a-zA-Z']+");

        while (!(line=sc.next()).equalsIgnoreCase("end")) {
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                if (!result.containsKey(matcher.group())) {
                    result.put(matcher.group(), 1);
                } else {
                    int oldCount = result.get(matcher.group());
                    result.put(matcher.group(), oldCount + 1);
                }
            }
        }
        System.out.println(result);
    }
}
