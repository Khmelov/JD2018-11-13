package by.it.berdnik.jd01_12;

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {
        HashMap<String, Integer> freq = new HashMap<String, Integer>();
        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile("([\\w']+)");
        String str;
        while (!(str = scanner.nextLine().trim()).equals("end")) {
            Matcher matcher = pattern.matcher(str);
            while (matcher.find()) {
                String word = matcher.group(1);
                Integer count = freq.get(word);
                if (count == null) {
                    freq.put(word, 1);
                } else {
                    freq.put(word, count + 1);
                }
            }
        }
        for (String s : freq.keySet()) {
            System.out.println(s + "=" + freq.get(s).toString());
        }
    }
}
