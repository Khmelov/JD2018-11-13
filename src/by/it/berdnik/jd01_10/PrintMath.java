package by.it.berdnik.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {

    public static void main(String[] args) {
        Class<Math> mathClass = Math.class;
        Method[] methods = mathClass.getMethods();
        for (Method method : methods) {
            StringBuilder sb = new StringBuilder();
            int modifiers = method.getModifiers();
            if (Modifier.isPublic(modifiers)) {
                sb.append("public ");
            }
            if (Modifier.isStatic(modifiers)) {
                sb.append("static ");
            }

            sb = sb.append(method.getReturnType() + " ");
            sb = sb.append(method.getName() + "(");
            Class<?>[] param = method.getParameterTypes();
            if (param.length == 0) sb.append(")");
            for (int i = 0; i < param.length; i++) {
                sb = sb.append(param[i]);
                if (i == param.length - 1) sb.append(")");
                else sb.append(",");
            }
            sb.append(method.getName());
            System.out.println(sb.toString());
        }
        Field[] publicFields = mathClass.getFields();
        for (Field field : publicFields) {
            StringBuilder sb = new StringBuilder();
            sb = sb.append(field.getType() + " ");
            sb = sb.append(field.getName());
            System.out.println(sb);
        }
    }
}
