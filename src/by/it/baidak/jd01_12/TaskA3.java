package by.it.baidak.jd01_12;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by user on 08.12.2018.
 */
public class TaskA3 {

    public static void main(String[] args) {

        ArrayList<Integer> values = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int indexZero = 0;
        while (true){
            String input = scanner.next();
            if (input.equals("end")) break;
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
