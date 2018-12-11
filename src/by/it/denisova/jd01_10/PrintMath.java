package by.it.denisova.jd01_10;

import sun.reflect.generics.tree.ReturnType;

import javax.xml.crypto.Data;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PrintMath {

    public static void main(String[] args) {
        Class<Math> mathClass = Math.class;
        Method[] methods = mathClass.getDeclaredMethods();
        Field[] fields = mathClass.getDeclaredFields();
        StringBuilder methName = new StringBuilder();

        for (Field field : fields) {
            int modifiers = field.getModifiers();
            if(Modifier.isPublic(modifiers)){
                if(Modifier.isStatic(modifiers)){
                    methName.append(field.getType()+" ");
                   methName.append(field.getName()+"}") ;
                }
            }
        }


        for (Method method: methods) {

            int modifiers = method.getModifiers();
            if (Modifier.isPublic(modifiers)){
                methName.append("public ");
                if(Modifier.isStatic(modifiers)){
                    methName.append("static ");
                }
                methName.append(method.getReturnType()+" ");
                methName.append(method.getName());
            }




            if (Modifier.isPublic(modifiers)||(Modifier.isPublic(modifiers)&& (Modifier.isStatic(modifiers)))){

                methName.append("(");

                Class<?>[] params =method.getParameterTypes();
                for (int i = 0; i < params.length; i++) {
                    String p = params[i].getName();
                    methName.append(p);
                    if(i != params.length-1) methName.append(",");
                }
                methName.append(")");
                methName.append("}");
            }

        }
      //  System.out.println(methName);
        String string = methName.toString();
        Pattern p = Pattern.compile("[(][a-z]+[,]*[a-z]*[)]");
        Pattern p1 = Pattern.compile("[}]");
        String[] str1 = p1.split(string);
        for (int i = 0; i <str1.length ; i++) {
           System.out.println(str1[i]);
        }

    }



 }
