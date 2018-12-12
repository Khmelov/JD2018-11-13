package by.it.lobkova.jd01_13;

import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double sum = 0;
        double result;
        for (; ; ) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("END")) break;
            try {
                System.out.println(input);
                double number = Double.parseDouble(input);

                sum += number;
                if (sum < 0) throw new ArithmeticException();
                result = Math.sqrt(sum);
                System.out.println(result);
            } catch (ArithmeticException | NumberFormatException e) {
                String nameException = e.getClass().getName();
                StackTraceElement[] stackTraceElement = e.getStackTrace();
                String myClass = TaskB.class.getName();
                for (StackTraceElement traceElement : stackTraceElement) {
                    String className = traceElement.getClassName();
                    if (className.equals(myClass)) {
                        int lineNumber = traceElement.getLineNumber();
                        System.out.printf("name: %s\nclass: %s\nline: %d\n", nameException, className, lineNumber);
                        break;
                    }
                }
            }
        }
    }
}

