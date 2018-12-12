package by.it.lobkova.jd01_13;

import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {
        try {
            if (Math.random()>0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("привет");
        }
        catch (NullPointerException | NumberFormatException e) {
            String nameException = e.getClass().getName();
            StackTraceElement[] stackTraceElements = e.getStackTrace();
            String taskAClass = TaskA.class.getName();
            for (StackTraceElement stackTraceElement : stackTraceElements) {
                String className = stackTraceElement.getClassName();
                if (className.equals(taskAClass)) {
                    int lineNumber = stackTraceElement.getLineNumber();
                    System.out.printf("name: %s\nclass: %s\nline: %d\n", nameException, className, lineNumber);
                    break;
                }
            }
        }

    }
}
