package by.it.zhivov.jd01_13;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        String input;
        double sum = 0;
        while (!((input = scr.next()).equals("END"))) {
            try {
                double value = Double.parseDouble(input);
                if (value < 0)
                    throw new ArithmeticException("Извлечение квадратного корня из отрицательного числа");
                sum += value;
                System.out.println(value+" "+Math.sqrt(sum));
            } catch (ArithmeticException | NumberFormatException e) {
                String nameException = e.getClass().getName();
                StackTraceElement[] stackTrace = e.getStackTrace();
                for (StackTraceElement stackTraceElement : stackTrace) {
                    String className = stackTraceElement.getClassName();
                    int lineNumber = stackTraceElement.getLineNumber();
                    if (className.equals(TaskB.class.getName())) {
                        System.out.printf(" name: %s\nclass: %s\n line: %d\n", nameException, className, lineNumber);
                        break;
                    }
                }

            }
        }
    }
}

