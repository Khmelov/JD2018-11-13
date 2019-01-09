package by.it.kruglenja.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) {
        Class string = String.class;
        Method[] methodsList = string.getDeclaredMethods();
        StringBuilder sb = new StringBuilder();
        for (Method method : methodsList) {
            int mod = method.getModifiers();
            if (!Modifier.isStatic(mod)){
                sb.append(method.getName());
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
