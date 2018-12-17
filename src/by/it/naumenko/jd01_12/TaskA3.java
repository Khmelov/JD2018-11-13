package by.it.naumenko.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        List<Integer> values = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int index=0;
        while (true) {
            String w = scanner.next();
            if (w.equalsIgnoreCase("end")) {
                break;
            }
            Integer value = Integer.valueOf(w);
            if (value>0)
                values.add(index++,value);
            else if(value<0)
                values.add(value);
            else
                values.add(index,value);
        }
        System.out.println(values);

    }
}
