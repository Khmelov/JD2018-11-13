package by.it.naumenko.jd01_10;

import sun.net.ftp.FtpDirEntry;

import java.lang.invoke.MethodType;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

public class PrintMath {

    public static void main(String[] args) {
        Class<Math> mathClass = Math.class;
        Method[] declaredMethods = mathClass.getDeclaredMethods();
        //MethodType.parameterArray();
        for (int i = 0; i < declaredMethods.length; i++) {
            System.out.println(declaredMethods[i].getParameterTypes());

//            StringBuilder stringBuilder = new StringBuilder();
//            int modifiers = declaredMethods[i].getModifiers();
//            if ((Modifier.PUBLIC & modifiers) == Modifier.PUBLIC) {
//                stringBuilder.append("public ");
//                if ((Modifier.STATIC & modifiers) == Modifier.STATIC) {
//                    stringBuilder.append("static ");
//                    stringBuilder.append(declaredMethods[i].getReturnType()+" ");
//                    stringBuilder.append(declaredMethods[i].getName());
//
//                    System.out.println(stringBuilder.toString());
//                }
//            }
        }
    }
}
