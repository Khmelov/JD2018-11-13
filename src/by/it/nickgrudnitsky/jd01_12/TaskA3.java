package by.it.nickgrudnitsky.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String s;
        int posision = 0;
        while (!"end".equals(s = scanner.next())) {
            Integer value = Integer.valueOf(s);
            if (value > 0) {
                arrayList.add(posision++, value);
            } else {
                if (value == 0) {
                    arrayList.add(posision, 0);
                } else {
                    arrayList.add(value);
                }
            }
        }
        System.out.println(arrayList);
    }
}
