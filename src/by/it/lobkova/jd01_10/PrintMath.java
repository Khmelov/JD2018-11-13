package by.it.lobkova.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {

    public static void main(String[] args) {
        Class<Math> mathClass = Math.class;
        Method[] methods = mathClass.getDeclaredMethods();
        for (Method method : methods) {
            StringBuilder sb = new StringBuilder();
            int modifiers = method.getModifiers();
            if (Modifier.isPublic(modifiers)) {
                sb.append("public ");
                if (Modifier.isStatic(modifiers)) {
                    sb.append("static ");
                }
                sb.append(method.getReturnType()+ " ");
                sb.append(method.getName());
                sb.append("(");
                Class<?>[] params =method.getParameterTypes();
                for (int i = 0; i < params.length; i++) {
                    String p = params[i].getName();
                    sb.append(p);
                    if(i != params.length-1) sb.append(",");
                }
                sb.append(")");
            }
            System.out.println(sb.toString());
        }
        Field[] fields = mathClass.getFields();
        for (Field field : fields) {
            StringBuilder sb = new StringBuilder();
            int fieldModifier = field.getModifiers();
            if (Modifier.isPublic(fieldModifier)) {
                if (Modifier.isStatic(fieldModifier)){
                    sb.append(field.getType() + " ").append(field.getName());
                }
            }
            System.out.println(sb);
        }
    }
}
