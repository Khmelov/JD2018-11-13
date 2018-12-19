package by.it.markelov.jd01_13;

import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {
        try {
            if (Math.random() > 0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("привет");
        } catch (NumberFormatException | NullPointerException e) {
            String nameEx = e.getClass().getName();//имя класса исключения
            StackTraceElement[] stackTrace = e.getStackTrace();//трассировка стека
            String myclassName = TaskA.class.getName();//имя класса (нашего)
            for (int i = 0; i < stackTrace.length; i++) {
                String stackElementName = stackTrace[i].getClassName();//имя класса элемента стека
                if (stackElementName.equals(myclassName)) {
                    String className = stackTrace[i].getClassName();//класс возник. исключения
                    int lineNumber = stackTrace[i].getLineNumber();//строка возник. исключения в классе
                    System.out.printf("name: %s\nclass: %s\nline: %d\n", nameEx, className, lineNumber);
                }

            }


        }
    }
}
