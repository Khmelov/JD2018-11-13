package by.it.karnilava.jd01_10;

import javax.naming.Name;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {

        public static void main(String[] args) {

            Class<String> s = String.class;
            Method[] methods = s.getDeclaredMethods();

            for(Method method: methods){
                if ((method.getModifiers() & Modifier.STATIC) != Modifier.STATIC)

                    System.out.println(method.getName());


            }



        }
    }


