package by.it.zakharenko.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {

    public static void main(String[] args) {
        Class<Math> mathClass = Math.class;
        Method[] methods = mathClass.getDeclaredMethods();
        for (Method method : methods) {
            StringBuilder sb = new StringBuilder();
            int modifiers = method.getModifiers();
            if (Modifier.isPublic(modifiers)) {
                sb.append("public ");
            }
            if (Modifier.isStatic(modifiers)) {
                sb.append("static ");
            }
            sb.append(method.getName());

            System.out.println(sb.toString());
        }
    }


}
