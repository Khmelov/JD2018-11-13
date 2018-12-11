package by.it.mnovikov.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) {
        Class<String> stringClass = String.class;
        Method[] methods = stringClass.getDeclaredMethods();

        for (Method method : methods) {
            if ((Modifier.STATIC & method.getModifiers()) != Modifier.STATIC){
                StringBuilder sb = new StringBuilder();
                sb.append(method.getName());
                System.out.println(sb);
            }
        }


    }
}
