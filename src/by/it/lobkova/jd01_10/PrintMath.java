package by.it.lobkova.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {

    public static void main(String[] args) {
        Class<Math> mathClass = Math.class;

        Method[] methods = mathClass.getDeclaredMethods();
        for (Method method : methods) {
            StringBuilder methName = new StringBuilder();
            int modifiers = method.getModifiers();
            if ((Modifier.PUBLIC & modifiers) == Modifier.PUBLIC) methName.append("public ");
            methName.append(method.getName());

        }

    }
}
