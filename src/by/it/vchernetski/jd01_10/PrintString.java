package by.it.vchernetski.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) {
        Class<String> classString = String.class;
        Method[] methods = classString.getDeclaredMethods();
        for (Method method : methods) {
            int modifier = method.getModifiers();
            if(Modifier.isStatic(modifier)) continue;
            else System.out.println(method.getName());
        }
    }
}
