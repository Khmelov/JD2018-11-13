package by.it.medvedeva.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.regex.*;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> structMath = Math.class;
        Method[] methods = structMath.getDeclaredMethods();
        Pattern pmethod = Pattern.compile("(.*) (\\w+\\.)+(\\w+)(\\(.*\\))$");
        for (Method method : methods) {
            if (
                //((method.getModifiers() & Modifier.STATIC) == Modifier.STATIC) &&
                    ((method.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC)
            ) {
                Matcher m = pmethod.matcher(method.toString());
                //System.out.println(method.toString());
                if (m.matches()) {
                    System.out.println(m.group(1)+" "+m.group(3)+m.group(4));
                }
            }
        }
        Field[] fields = structMath.getDeclaredFields();
        Pattern pfield = Pattern.compile("(.*) (\\w+\\.)+(\\w+)$");
        for (Field field : fields) {
            if (
                //((method.getModifiers() & Modifier.STATIC) == Modifier.STATIC) &&
                    ((field.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC)
            ) {
                Matcher m = pfield.matcher(field.toString());
                //System.out.println(field.toString());
                if (m.matches()) {
                    System.out.println(m.group(1)+" "+m.group(3));
                }
            }
        }
    }
}


