package by.it.malishevskiy.jd01_13;

public class TaskA {
        public static void main(String[] args) {
            try {
                if (Math.random() > 0.5)
                    new HashMap < String, String>(null);
                else Integer.parseInt("привет");
            } catch (NullPointerException | NumberFormatException e) {
                String nameException = e.getClass().getName();
                StackTraceElement[] stackTrace = e.getStackTrace();
                String myClass=TaskA.class.getName();
                for (StackTraceElement element : stackTrace) {
                    String className = element.getClassName();
                    if (className.equals(myClass)) {
                        int lineNumber = element.getLineNumber();
                        System.out.printf(" name: %s\nclass: %s\nline: %d\n",nameException,className,lineNumber);
                        break;
                    }
                }
            }

        }
    }
