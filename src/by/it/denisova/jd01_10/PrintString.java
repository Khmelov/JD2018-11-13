package by.it.denisova.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.regex.Pattern;

public class PrintString {
    public static void main(String[] args) {
        Class<String> stringClass = String.class;
        Method[] methods = stringClass.getDeclaredMethods();
        StringBuilder stringBuilder = new StringBuilder();

        for (Method method : methods) {
            int modific = method.getModifiers();
            if (!(Modifier.isStatic(modific))){
                stringBuilder.append(method.getName()+" ");
                stringBuilder.append("}");
            }
        }



        String string = stringBuilder.toString();
        Pattern p1 = Pattern.compile("[}]");
        String[] str1 = p1.split(string);
        for (int i = 0; i <str1.length ; i++) {
            System.out.println(str1[i]);
        }
    }
}
