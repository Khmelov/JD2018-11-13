package by.it.seroglazov.jd01_13;

import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {
        try {
            if (Math.random() > 0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("привет");
        } catch (NullPointerException | NumberFormatException e){
            StackTraceElement[] ste = e.getStackTrace();
            String className = TaskA.class.getName();
            for (StackTraceElement elem : ste) {
                if (elem.getClassName().equals(className)){
                    System.out.println("  name: " + e.getClass().getName());
                    System.out.println(" class: " + className);
                    System.out.println("  line: " + elem.getLineNumber());
                    break;
                }
            }
        }
    }
}
