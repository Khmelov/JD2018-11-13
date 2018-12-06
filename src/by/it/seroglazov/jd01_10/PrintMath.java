package by.it.seroglazov.jd01_10;

import java.lang.reflect.*;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> math = Math.class;
        Method[] methods = math.getDeclaredMethods();
        Field[] fields = math.getFields();
        StringBuilder sb = new StringBuilder(50);
        for (Method met : methods) {
            int mod = met.getModifiers();
            if (Modifier.isPublic(mod)) {
                sb.append("public ");
                if (Modifier.isStatic(mod)) sb.append("static ");
                sb.append(met.getReturnType().getName());
                sb.append(' ');
                sb.append(met.getName());
                sb.append('(');
                Class<?>[] pars = met.getParameterTypes();
                for (int i = 0; i < pars.length; i++) {
                    sb.append(pars[i]);
                    if (i != pars.length - 1) sb.append(',');
                }
                sb.append(")\n");
            }
        }
        sb.append('\n');
        for (Field f : fields) {
            int mod = f.getModifiers();
            if (Modifier.isPublic(mod)) {
                sb.append("public ");
                if (Modifier.isStatic(mod)) sb.append("static ");
                sb.append(f.getType());
                sb.append(' ');
                sb.append(f.getName());
                sb.append('\n');
            }
        }
        System.out.println(sb);
    }
}
