package by.it.naumenko.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) {
        Class<String> stringClass = String.class;
        Method[] declaredMethods = stringClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            int modifiers = declaredMethod.getModifiers();
            StringBuilder stringBuilder = new StringBuilder();
            if ((Modifier.STATIC & modifiers) != Modifier.STATIC) {
                stringBuilder.append(declaredMethod.getName());
                System.out.println(stringBuilder.toString());
            }
        }
    }
}
