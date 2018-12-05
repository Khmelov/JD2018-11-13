package by.it.seroglazov.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) {
        Class string = String.class;
        Method[] mets = string.getDeclaredMethods();
        StringBuilder sb = new StringBuilder(50);
        for (Method met : mets) {
            int mod = met.getModifiers();
            if (!Modifier.isStatic(mod)){
                sb.append(met.getName());
                sb.append('\n');
            }
        }
        System.out.println(sb);
    }
}
