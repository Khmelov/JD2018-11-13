package by.it.lobkova.jd01_12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int indexZero = 0;
        for (; ;) {
            String input = scanner.next();
            if (input.equalsIgnoreCase("end")) break;
            Integer value = Integer.valueOf(input);
            if (value == 0) arrayList.add(indexZero, value);
            else if (value > 0) arrayList.add(indexZero++, value);
            else {
                arrayList.add(value);
            }
        }
        System.out.println(arrayList);


    }
}
