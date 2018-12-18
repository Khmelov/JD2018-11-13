package by.it.nickgrudnitsky.jd01_12;


import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {
        Map<String, Integer> hashMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        String string;
        Pattern pattern = Pattern.compile("[A-Za-z]+'?[A-za-z]?");
        while (!"end".equalsIgnoreCase(string = scanner.nextLine())) {
            Matcher matcher = pattern.matcher(string);
            while (matcher.find()) {
                String word = matcher.group();
                if (!hashMap.containsKey(word)) {
                    hashMap.put(word, 1);
                } else {
                    hashMap.put(word, hashMap.get(word) + 1);

                }
            }
        }
        System.out.println(hashMap);
    }
}

