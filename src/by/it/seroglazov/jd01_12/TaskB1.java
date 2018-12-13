package by.it.seroglazov.jd01_12;

import java.util.HashMap;
import java.util.Scanner;

public class TaskB1 {
    public static void main(String[] args) {
        HashMap<String, Integer> wmap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        for (;;) {
            String input = scanner.next();
            if (input.equals("end"))
                break;
            input = input.replaceAll("[-.!?,;:]", "");
            wmap.merge(input, 1, (v1, v2) -> v1 + v2); // M A G I C
        }
        System.out.println(wmap);
    }
}
