package by.it.naumenko.jd01_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> strings = new ArrayList<>();
        while (true) {
            String w = scanner.next();
            if (w.equalsIgnoreCase("end"))
                break;
            try {
                strings.add(Double.parseDouble(w));
            } catch (NumberFormatException e) {
                String nameExeption = e.getClass().getName();
                StackTraceElement[] stackTrace = e.getStackTrace();
                String name = TaskB.class.getName();
                for (StackTraceElement stackTraceElement : stackTrace) {
                    String myClass = stackTraceElement.getClassName();
                    if (name.equals(myClass)) {
                        int lineNumber = stackTraceElement.getLineNumber();
                        System.out.printf(" name: %s\nclass: %s\n line: %d", nameExeption, myClass, lineNumber);
                        break;
                    }
                }

//                System.out.println("невозможно перевести в число это строка");
            }
        }
        System.out.println(strings);
        List<Double> number = new ArrayList<>();
        double sum = 0;
        for (Double numbers : strings) {
            double a;
            sum+=numbers;
            try {
                a = Math.sqrt(sum);
                if (sum < 0) {
                    throw new ArithmeticException();
                }
                number.add(a);
            } catch (ArithmeticException e) {
                String nameExeption = e.getClass().getName();
                StackTraceElement[] stackTrace = e.getStackTrace();
                String name = TaskB.class.getName();
                for (StackTraceElement stackTraceElement : stackTrace) {
                    String myClass = stackTraceElement.getClassName();
                    if (name.equals(myClass)) {
                        int lineNumber = stackTraceElement.getLineNumber();
                        System.out.printf(" name: %s\nclass: %s\n line: %d", nameExeption, myClass, lineNumber);
                        break;
                    }
                }
            }
        }
        System.out.println(number);

    }
}
