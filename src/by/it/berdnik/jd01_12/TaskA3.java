package by.it.berdnik.jd01_12;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        ArrayList<Integer> values = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int indexZero = 0;
        for (; ; ) {
            String input = scanner.next();
            if (input.equalsIgnoreCase("end"))
                break;
            Integer value = Integer.valueOf(input);
            if (value == 0)
                values.add(indexZero, value);
            else if (value > 0)
                values.add(indexZero++, value);
            else
                values.add(value);
        }
        System.out.println(values);
    }
}
