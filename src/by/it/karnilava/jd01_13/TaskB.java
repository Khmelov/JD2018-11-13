package by.it.karnilava.jd01_13;

import java.util.Scanner;


public class TaskB {
    public static void main(String[] args) throws NumberFormatException, ArithmeticException {

        Scanner scan = new Scanner(System.in);
        String line;
        double a;
        double sum=0;
        try {

            while (!(line = scan.nextLine()).equals("END")) {
                a = Double.parseDouble(line);
                sum = sum + a;
                if (sum<0){
                    throw new ArithmeticException();
                }
                double b = Math.sqrt(sum);
                System.out.println(a + " " + b);

            }
        }
        catch (ArithmeticException e){

            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement element : stackTrace) {
                if (TaskB.class.getName().equals(element.getClassName())) {

                    String name = e.getClass().getName();
                    String clname = element.getClassName();
                    int number = element.getLineNumber();
                    System.out.printf(" name: %s\n" +
                                    "class: %s\n" +
                                    " line: %d\n",
                            name, clname, number);
                    break;
                }
            }

        }

        catch (NumberFormatException e) {

            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement element : stackTrace) {
                if (TaskB.class.getName().equals(element.getClassName())) {

                    String name = e.getClass().getName();
                    String clname = element.getClassName();
                    int number = element.getLineNumber();
                    System.out.printf(" name: %s\n" +
                                    "class: %s\n" +
                                    " line: %d\n",
                            name, clname, number);
                    break;
                }
            }
        }

    }
}
