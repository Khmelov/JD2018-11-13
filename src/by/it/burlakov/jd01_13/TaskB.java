package by.it.burlakov.jd01_13;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;

        double sum = 0;
        while(!(line = scanner.nextLine()).equalsIgnoreCase("end")){
            try {
                double number = Double.parseDouble(line);
                sum += number;
                if(sum <= 0){
                    throw new ArithmeticException();
                }
                System.out.println(Math.sqrt(sum));

            } catch (NumberFormatException | ArithmeticException e ){
                String name = e.getClass().getName();
                System.out.println(name);
                StackTraceElement[] stackTrace = e.getStackTrace();
                String myClass = TaskB.class.getName();

                for (StackTraceElement element : stackTrace) {
                    String className = element.getClassName();
                    if(className.equals(myClass)){
                        int lineNumber = element.getLineNumber();
                        System.out.printf("name: %s\nclass: %s\nline: %d\n", name, className, lineNumber);
                        break;
                    }
                }

            }



        }
    }
}
