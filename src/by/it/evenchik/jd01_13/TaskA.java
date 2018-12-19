package by.it.evenchik.jd01_13;

import java.util.HashMap;


    public class TaskA {
        public static void main(String[] args) {
            try{
                if (Math.random()>0.5){
                    new HashMap<String, String>(null);
                } else {
                    Integer.parseInt("привет");
                }

            } catch (NullPointerException | NumberFormatException e){
                String name = e.getClass().getName();
                StackTraceElement[] stackTrace = e.getStackTrace();
                String myClass = by.it.burlakov.jd01_13.TaskA.class.getName();

                for (StackTraceElement element : stackTrace) {
                    String className = element.getClassName();
                    if(className.equals(myClass)){
                        int lineNumber = element.getLineNumber();
                        System.out.printf(
                                "name: %s\n" +
                                "class: %s\n" +
                                "line: %d\n",
                                name, className, lineNumber);
                        break;
                    }
                }

                System.out.println("catched " + name);
            }

        }
    }

