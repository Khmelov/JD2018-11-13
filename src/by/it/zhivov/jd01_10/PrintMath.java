package by.it.zhivov.jd01_10;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> mathClass = Math.class;
        Method[] declaredMethods = mathClass.getDeclaredMethods();
        for (Method method : declaredMethods) {
            int modifiers = method.getModifiers();
            if (Modifier.isPublic(modifiers)) {
                StringBuilder sb=new StringBuilder();
                String s = sb.append(method).toString();
                s=s.replaceAll("java.lang.Math.", "");
                System.out.println(s);
            }
        }
        Field[] declaredFields = mathClass.getDeclaredFields();
        for (Field field : declaredFields) {
            int modifiers = field.getModifiers();
            if (Modifier.isPublic(modifiers)) {
                StringBuilder sb=new StringBuilder();
                String s = sb.append(field).toString();
                s=s.replaceAll("java.lang.Math.", "");
                System.out.println(s);
            }
        }
    }
}
