package by.it.naumenko.jd01_13;

import java.text.NumberFormat;
import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {
        try {
            if (Math.random() > 0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("привет");
        } catch (NullPointerException| NumberFormatException e){
            //e.printStackTrace();
            String nameExeption = e.getClass().getName();
            // System.out.println(e.getClass().getName());
            StackTraceElement[] stackTrace = e.getStackTrace();
            String name = TaskA.class.getName();
            for (StackTraceElement stackTraceElement : stackTrace) {
                String myClass = stackTraceElement.getClassName();
                if(name.equals(myClass)){
                    int lineNumber = stackTraceElement.getLineNumber();
                    System.out.printf(" name: %s\nclass: %s\n line: %d",nameExeption,myClass,lineNumber);
                    break;
                }
            }
        }
    }
}
