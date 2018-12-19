package by.it.nickgrudnitsky.jd01_13;

import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {
        try {
            if (Math.random() > 0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("привет");
        } catch (NullPointerException | NumberFormatException e) {
            String name = e.getClass().getName();
            StackTraceElement[] stackTrace = e.getStackTrace();
            String myClass = TaskA.class.getName();
            for (StackTraceElement stackTraceElement : stackTrace) {
                String className = stackTraceElement.getClassName();
                if (className.equals(myClass)) {
                    int lineNumber = stackTraceElement.getLineNumber();
                    System.out.printf("name: %s\nclass: %s\nline: %d", name, myClass, lineNumber);
                }
            }
        }
    }
}
