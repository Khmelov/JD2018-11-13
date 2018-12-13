package by.it.lobkova.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {

    public static void main(String[] args) {
        Class<String> stringClass = String.class;
        Method[] methods = stringClass.getDeclaredMethods();

        for (Method method : methods) {
            StringBuilder sb = new StringBuilder();
            int modifiers = method.getModifiers();

            if (!(Modifier.isStatic(modifiers))) {
                sb.append(method.getName());
            }

            System.out.println(sb.toString());
            sb.append(method.getName());

        }
    }

}
