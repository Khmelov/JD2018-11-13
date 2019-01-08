package by.it.kruglenja.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> math = Math.class;
        Method[] methodList = math.getDeclaredMethods();
        Field[] fieldsList = math.getFields();
        StringBuilder sb = new StringBuilder();
        for (Method method : methodList) {
            int mod = method.getModifiers();
            if (Modifier.isPublic(mod)) {
                sb.append("public ");
                if (Modifier.isStatic(mod)) {
                    sb.append("static ");
                }
                sb.append(method.getReturnType().getName());
                sb.append(" ");
                sb.append(method.getName());
                sb.append("(");
                Class<?>[] param = method.getParameterTypes();
                for (int i = 0; i < param.length; i++) {
                    sb.append(param[i]);
                    if (i != param.length - 1) {
                        sb.append(",");
                    }
                }
                sb.append(") \n");
            }
        }
        sb.append("\n");
        for (Field field : fieldsList) {
            int mod = field.getModifiers();
            if (Modifier.isPublic(mod)) {
                sb.append("public ");
                if (Modifier.isStatic(mod)) {
                    sb.append("static ");
                }
                sb.append(field.getType());
                sb.append(" ");
                sb.append(field.getName());
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
