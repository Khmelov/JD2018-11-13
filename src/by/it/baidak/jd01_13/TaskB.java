package by.it.baidak.jd01_13;

import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) {

        String end = "END";
        int summ = 0;
        Scanner scanner = new Scanner(System.in);
        while(true){
            String message = scanner.next();
            if(message.equals(end)) break;
            try{
                double tmp = Double.parseDouble(message);
                if(tmp < 0) throw new ArithmeticException("ниже ноля или ноль");
                summ+= tmp;
                System.out.println(Math.sqrt(summ));
            }catch (NumberFormatException | ArithmeticException e){
                String nameException = e.getClass().getName();
                StackTraceElement[] stackTrace = e.getStackTrace();
                String myClass=TaskB.class.getName();
                for (StackTraceElement element : stackTrace) {
                    String className = element.getClassName();
                    if (className.equals(myClass)) {
                        int lineNumber = element.getLineNumber();
                        System.out.printf(" name: %s\nclass: %s\n line: %d\n",nameException,className,lineNumber);
                        break;
                    }
                }
            }
        }
    }
}
