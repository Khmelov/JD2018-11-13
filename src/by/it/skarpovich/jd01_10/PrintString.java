package by.it.skarpovich.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
//Найти нестатические методы в классе String
    public static void main(String[] args) {
        Class<String> stringClass = String.class;
        Method[] methods = stringClass.getDeclaredMethods();
        for (Method method : methods) {
            StringBuilder sb = new StringBuilder();
//Побитовое сравнение
            if ((method.getModifiers() & Modifier.STATIC) !=Modifier.STATIC) {
                sb.append(method.getName());
                System.out.println(sb.toString());
            }
        }
    }
}
