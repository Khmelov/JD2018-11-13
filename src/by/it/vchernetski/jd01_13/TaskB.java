package by.it.vchernetski.jd01_13;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;
        double sum = 0;
        while (!((input = sc.next()).equals("END"))) {
            try {
                double inputd = Double.parseDouble(input);
                if(inputd<0) throw new ArithmeticException("корень из отрицательного числа");
                sum+=inputd;
                System.out.println(inputd);
                System.out.println(Math.sqrt(sum));
            }
            catch (Exception e) {
                StackTraceElement[] stackTrace = e.getStackTrace();
                for (StackTraceElement element : stackTrace) {
                    if (TaskB.class.getName().equals(element.getClassName())) {
                        String name = e.getClass().getName();
                        String classname = element.getClassName();
                        int num = element.getLineNumber();
                        System.out.printf(" name: %s\nclass: %s\n line: %d\n", name, classname, num);
                        break;
                    }
                }
            }
        }
    }
}
