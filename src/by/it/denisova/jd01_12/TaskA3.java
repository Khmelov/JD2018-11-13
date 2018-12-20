package by.it.denisova.jd01_12;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> values = new ArrayList<>();
        String input = scanner.next();
         int indexZero = 0;
        while (!input.equalsIgnoreCase("end")) {
            Integer value = Integer.valueOf(input);
            if (value == 0) {
                values.add(indexZero,value);
            }
            else if (value >0) {
                values.add(indexZero++,value);
            }
            else {
                values.add(value);
            }
            input = scanner.next();
        }
        System.out.println(values);
    }
}
