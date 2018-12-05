package by.it.markelov.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) {
        Class<String> stringClass = String.class;
        Method[] declaredMethods = stringClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            int modifiers = declaredMethod.getModifiers();
            if (!Modifier.isStatic(modifiers)) {
                System.out.println(declaredMethod.getName());
            }
        }


    }
}
