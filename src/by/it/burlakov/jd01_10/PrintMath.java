package by.it.burlakov.jd01_10;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> math = Math.class;
        Method[] methArr = math.getDeclaredMethods();
        Field[] fieldArr = math.getFields();
        StringBuilder sb = new StringBuilder(0);

        for (Method m : methArr) {
            if (Modifier.isPublic(m.getModifiers())) {
                sb.append(m).append("\n");
            }
        }

        for (Field f : fieldArr) {
            if (Modifier.isPublic(f.getModifiers())) {
                sb.append(f).append("\n");
            }
        }

        Pattern pattern = Pattern.compile("java.lang.Math.");
        Matcher matcher = pattern.matcher(sb);
        while (matcher.find()) {
            System.out.println(matcher.replaceAll(""));
        }
    }
}