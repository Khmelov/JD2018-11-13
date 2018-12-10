package by.it.baidak.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * Created by user on 04.12.2018.
 */
public class PrintMath {
    public static void main(String[] args) {

        Class<Math> mClass = Math.class;

        Method[] declaredMethods = mClass.getDeclaredMethods();
        Field[] declareFields = mClass.getDeclaredFields();
        StringBuilder mName = new StringBuilder();

        for (Method declaredMethod : declaredMethods) {
            int modifiers = declaredMethod.getModifiers();
            if(Modifier.isPublic(modifiers) & Modifier.isStatic(modifiers)) {
                mName.append("public ");
                mName.append("static ");
                mName.append(declaredMethod.getReturnType() + " ");
                mName.append(declaredMethod.getName());
                String tmp = Arrays.toString(declaredMethod.getParameterTypes());
                String tmp2 = tmp.replaceAll("\\s","");
                mName.append("(" + tmp2.substring(1,tmp2.length() - 1) + ")\n");
            }
        }

        for (Field declareField : declareFields) {
            int modifiers = declareField.getModifiers();
            if(Modifier.isPublic(modifiers) & Modifier.isStatic(modifiers)) {
                mName.append("public ");
                mName.append("static ");
                mName.append(declareField.getType() + " ");
                mName.append(declareField.getName() + "\n");
            }
        }

        System.out.println(mName);
    }
}
