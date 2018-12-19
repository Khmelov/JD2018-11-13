package by.it.nickgrudnitsky.jd01_13;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) throws ArithmeticException {
        Scanner scanner = new Scanner(System.in);
        String numb;
        Double result = 0.0;
        try {
            while (!(numb = scanner.nextLine()).equalsIgnoreCase("end")) {
                Double number = Double.valueOf(numb);
                System.out.println(number);
                if (number < 0) throw new ArithmeticException();
                result += number;
                System.out.println(Math.sqrt(result));
            }
        } catch (NumberFormatException | ArithmeticException e) {
            String name = e.getClass().getName();
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement stackTraceElement : stackTrace) {
                String className = stackTraceElement.getClassName();
                if (className.equals(TaskB.class.getName())) {
                    int lineNumber = stackTraceElement.getLineNumber();
                    System.out.printf("name: %s\nclass: %s\nline: %d", name, className, lineNumber);
                }
            }
        }
    }
}

