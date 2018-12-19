package by.it.seroglazov.jd01_13;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double sum = 0;
        while (true) {
            try {
                String line = sc.nextLine();
                if (line.equalsIgnoreCase("end")) break;
                double dNum = Double.parseDouble(line);
                System.out.println(dNum);
                sum += dNum;
                double square = Math.sqrt(sum);
                if (Double.isNaN(square))
                    throw new ArithmeticException("square root error");
                System.out.println(square);

            } catch (NumberFormatException | ArithmeticException e) {
                StackTraceElement[] ste = e.getStackTrace();
                String className = TaskB.class.getName();
                for (StackTraceElement elem : ste) {
                    if (elem.getClassName().equals(className)) {
                        System.out.println("  name: " + e.getClass().getName());
                        System.out.println(" class: " + className);
                        System.out.println("  line: " + elem.getLineNumber());
                        break;
                    }
                }
            }
        }
    }
}
