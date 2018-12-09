package by.it.karnilava.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;


public class PrintMath {
    public static void main(String[] args) {

        Class<Math> math = Math.class;
       Method [] methods = math.getDeclaredMethods();

       for(Method method: methods){
           if ((method.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC )
//               System.out.println(method);

               System.out.println(method.toString().replace("java.lang.Math.",""));
       }
       Field [] fields = math.getDeclaredFields();
       for (Field field: fields){
           if ((field.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC ){
               System.out.println(field.toString().replace("java.lang.Math.",""));
           }

       }



    }
}
