package by.it.nickgrudnitsky.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> math = Math.class;
        Method[] methods = math.getMethods();
        Field[] fields = math.getFields();
        for (Method method : methods) {
            StringBuilder sb = new StringBuilder();
            int modifiers = method.getModifiers();
            if (Modifier.isPublic(modifiers)) {
                sb = sb.append("public ");
            }
            if (Modifier.isStatic(modifiers)) {
                sb = sb.append("static ");
            }
            sb = sb.append(method.getReturnType() + " ");
            sb = sb.append(method.getName() + "(");
            Class<?>[] parameterTypes = method.getParameterTypes();
            if (parameterTypes.length == 0) sb.append(")");
            for (int i = 0; i < parameterTypes.length; i++) {
                sb = sb.append(parameterTypes[i]);
                if (i == parameterTypes.length - 1) sb.append(")");
                else sb.append(",");
            }
            System.out.println(sb);
        }
        for (Field field : fields) {
            StringBuilder sb = new StringBuilder();
            sb = sb.append(field.getType() + " ");
            sb = sb.append(field.getName());
            System.out.println(sb);
        }
    }
}
