package by.it.zhivov.jd01_12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int indexZero = 0;
        for (; ; ) {
            String next = scanner.next();
            if (next.equalsIgnoreCase("end")) {
                break;
            }
            Integer val = Integer.valueOf(next);
            if (val > 0) {
                list.add(indexZero, val);
                indexZero++;
            } else if (val == 0) {
                list.add(indexZero, val);
            } else list.add(val);
        }
        System.out.println(list);
    }

}
