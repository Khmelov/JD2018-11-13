package by.it.skarpovich.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> mathView = Math.class;
        Method[] methods = mathView.getDeclaredMethods();
        Field[] fields = mathView.getFields();
        StringBuilder sbuilder = new StringBuilder();

        //Алгоритм для методов
        for (Method m : methods) {
            int modif = m.getModifiers();
            if (Modifier.isPublic(modif)) {
                sbuilder.append("public ");
                if (Modifier.isStatic(modif))
                    sbuilder.append("static ");
                sbuilder.append(m.getReturnType().getName());
                sbuilder.append(" ");
                sbuilder.append(m.getName());
                sbuilder.append("(");
                System.out.println(sbuilder);
                Class<?>[] parser = m.getParameterTypes();
                for (int i = 0; i < parser.length; i++) {
                    sbuilder.append(parser[i]);
                    if (i != parser.length - 1) sbuilder.append(",");
                }
                sbuilder.append(")\n");
            }
        }
        sbuilder.append('\n');
        //Алгоритм для полей
        for (Field f : fields) {
            int modif = f.getModifiers();
            if (Modifier.isPublic(modif)) {
                sbuilder.append("public ");
                if (Modifier.isStatic(modif))
                    sbuilder.append("static ");
                {
                    sbuilder.append(f.getType());
                    sbuilder.append(" ");
                    sbuilder.append(f.getName());
                    sbuilder.append("\n");
                }
            }
            System.out.println(sbuilder);
        }
    }

}

