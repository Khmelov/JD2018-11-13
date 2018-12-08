package by.it.medvedeva.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PrintString {
    public static void main(String[] args) {
        Class<String> structString = String.class;
        Method[] methods = structString.getDeclaredMethods();
        Pattern pmethod = Pattern.compile("(.*) (\\w+\\.)+(\\w+)(\\(.*\\))$");
        for (Method method : methods) {
            if (
                    ((method.getModifiers() & Modifier.STATIC) != Modifier.STATIC)
            ) {
                Matcher m = pmethod.matcher(method.toString());
                //System.out.println(method.toString());
                if (m.matches()) {
                    //System.out.println(m.group(1) + " " + m.group(3) + m.group(4));
                    System.out.println(m.group(3));
                }
            }
        }
    }
}
