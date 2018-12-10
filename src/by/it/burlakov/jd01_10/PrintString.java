package by.it.burlakov.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) {


        Class<String> str = String.class;
        Method[] methArr = str.getDeclaredMethods();
        StringBuilder sb = new StringBuilder();
        for (Method m : methArr) {

            if (!Modifier.isStatic(m.getModifiers())) {

                sb.append(m.getName()).append("\n");
            }

        }
        System.out.println(sb);
    }
}




