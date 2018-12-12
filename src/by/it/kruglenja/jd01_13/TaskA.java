package by.it.kruglenja.jd01_13;

import javafx.concurrent.Task;

import java.text.ParseException;
import java.util.HashMap;

/**
 * Created by user on 11.12.2018.
 */
public class TaskA {
    public static void main(String[] args) {
        try {
            if (Math.random() > 0.5) {
                new HashMap<String, String>(null);
            } else {
                Integer.parseInt("привет");
            }
        }catch (NullPointerException | NumberFormatException e){
            StackTraceElement[] stckTrElem = e.getStackTrace();
            for (StackTraceElement element : stckTrElem) {
                if (TaskA.class.getName().equals(element.getClassName())){
                    System.out.println(element);
                    String name = e.getClass().getName();
                    String clname = element.getClassName();
                    int num = element.getLineNumber();
                    System.out.printf(
                            " name: %s \n" +
                            "class: %s \n" +
                            " line: %d ", name, clname, num);
                    break;
                }
            }
        }
    }
}
