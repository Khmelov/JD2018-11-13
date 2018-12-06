package by.it.mnovikov.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by user on 04.12.2018.
 */
public class PrintMath {
    public static void main(String[] args) {
        Class<Math> mathClass = Math.class;
        Method[] methods = mathClass.getDeclaredMethods();
        for (Method method : methods) {
            StringBuilder sb = new StringBuilder();
            int modifiers = method.getModifiers();
            if ((Modifier.PUBLIC & modifiers) != Modifier.PUBLIC)
                sb.append("no public ");

            sb.append(method.getName());
            System.out.println(sb.toString());
        }
    }
}
