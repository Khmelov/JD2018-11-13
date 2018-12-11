package by.it.mnovikov.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.regex.Pattern;

/**
 * Created by user on 04.12.2018.
 */
public class PrintMath {
    public static void main(String[] args) {
        Class<Math> mathClass = Math.class;
        Method[] methods = mathClass.getDeclaredMethods();
        Field[] fields = mathClass.getDeclaredFields();
        for (Method method : methods) {
            if ((Modifier.PUBLIC & method.getModifiers()) == Modifier.PUBLIC) {
                String s = String.valueOf(method);
                System.out.println(s.replaceAll("java.lang.Math.", ""));

            }
        }
        for (Field field : fields) {
            if ((Modifier.PUBLIC & field.getModifiers()) == Modifier.PUBLIC){
                String s = String.valueOf(field);
                System.out.println(s.replaceAll("java.lang.Math.", ""));

            }

        }
    }
}
