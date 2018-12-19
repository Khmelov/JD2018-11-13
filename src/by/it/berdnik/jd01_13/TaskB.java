package by.it.berdnik.jd01_13;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string;
        double dbl = 0;
        while (!(string = scanner.nextLine()).equalsIgnoreCase("end")) {
            try {
                double num = Double.parseDouble(string);
                if (num <= 0) {
                    throw new ArithmeticException();
                }
                dbl += num;
                System.out.println(num + " " + Math.sqrt(dbl));
            } catch (NumberFormatException | ArithmeticException err){
                String name = err.getClass().getName();
                StackTraceElement[] stack = err.getStackTrace();
                for (StackTraceElement element : stack){
                    String className = element.getClassName();
                    if (className.equals(TaskB.class.getName())){
                        int lineNum = element.getLineNumber();
                        System.out.printf("Name: %s\nClass: %s\nline: %d\n", name, className, lineNum);
                        break;
                    }
                }
            }
        }
    }
}