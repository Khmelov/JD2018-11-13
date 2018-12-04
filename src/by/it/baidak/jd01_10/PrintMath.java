package by.it.baidak.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by user on 04.12.2018.
 */
public class PrintMath {
    public static void main(String[] args) {

        Class<Math> mClass = Math.class;
        Method[] declaredMethods = mClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            StringBuilder mName = new StringBuilder();
            int modifiers = declaredMethod.getModifiers();
            if((Modifier.PUBLIC & modifiers) == Modifier.PUBLIC) mName.append("public ");
            if(Modifier.isStatic(modifiers)) mName.append("static ");
        }
    }
}
