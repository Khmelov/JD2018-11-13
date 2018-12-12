package by.it.kovalyova.jd01_12;

import java.util.HashMap;
import java.util.regex.*;
import java.util.Scanner;

public class TaskB1 {
    public static void main(String[] args) {
        HashMap<String, Integer> freq = new HashMap<String, Integer>();
        Scanner scan = new Scanner(System.in);
        Pattern pword = Pattern.compile("([\\w']+)");
        String str;
        while (!(str = scan.nextLine().trim()).equals("end")) {
            Matcher m = pword.matcher(str);
            while (m.find()) {
                String word = m.group(1);
                Integer count = freq.get(word);
                if (count == null) {
                    freq.put(word, 1);
                }
                else {
                    freq.put(word, count + 1);
                }
            }
        }
        for (String s: freq.keySet()){
            System.out.println(s+"="+freq.get(s).toString());
        }
    }
}
