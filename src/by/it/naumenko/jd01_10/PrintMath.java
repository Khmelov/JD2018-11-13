package by.it.naumenko.jd01_10;

import sun.net.ftp.FtpDirEntry;

import java.lang.invoke.MethodType;
import java.lang.reflect.*;

public class PrintMath {

    /////////Поиск полей класса Math//////////////
    private static void filds() {
        Class<Math> mathClass = Math.class;
        Field[] fields = mathClass.getFields();

        for (Field field : fields) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(field.getType()).append(" ").append(field.getName());
            System.out.println(stringBuilder.toString());
        }
    }

    ///////Поиск параметров медода////////////////////
    private static String paramMethod(Method declaredMethods) {
        String signatura;
        StringBuilder stringBuilder = new StringBuilder();
        Class<?>[] parameterTypes = declaredMethods.getParameterTypes();
        for (int j = 0; j < parameterTypes.length; j++) {
            String param = parameterTypes[j].getName();
            stringBuilder.append(param);
            if (j != parameterTypes.length - 1)
                stringBuilder.append(",");
        }
        signatura=stringBuilder.toString();
        return signatura;
    }

    public static void main(String[] args) {
        Class<Math> mathClass = Math.class;
        Method[] declaredMethods = mathClass.getDeclaredMethods();
        for (int i = 0; i < declaredMethods.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            int modifiers = declaredMethods[i].getModifiers();
            if ((Modifier.PUBLIC & modifiers) == Modifier.PUBLIC) {
                stringBuilder.append("public ");
                if ((Modifier.STATIC & modifiers) == Modifier.STATIC) {
                    stringBuilder.append("static ");
                    stringBuilder.append(declaredMethods[i].getReturnType() + " ");
                    stringBuilder.append(declaredMethods[i].getName());
                    stringBuilder.append("(");
                    stringBuilder.append(paramMethod(declaredMethods[i]));
                    stringBuilder.append(")");
                    System.out.println(stringBuilder.toString());
                }
            }
        }
        filds();
    }
}
