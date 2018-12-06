package by.it.denisova.jd01_10;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class BeanTester extends Bean{

    public static void main(String[] args) throws Exception{
        Class<Bean> bean = Bean.class;
        Class<? extends Annotation> onno = Param.class;
        Method a = onno.getMethod("a");
        Method b = onno.getMethod("b");
        Method[] methods = bean.getDeclaredMethods();
        Object instance = bean.getDeclaredConstructor().newInstance();// иницивлизация bean
        for (Method method : methods) {
            if(method.isAnnotationPresent(onno)){

                Annotation annotation = method.getAnnotation(onno);
                int aValue = (int)  a.invoke(annotation);
                int bValue = (int)  b.invoke(annotation);
                String name = method.getName();
                double res;

                if ((method.getModifiers() & Modifier.STATIC) == Modifier.STATIC){
                    res = (double) method.invoke(null, aValue, bValue);
                }
                else {
                    res = (double) method.invoke(instance, aValue, bValue);
                }
                System.out.println("Для " + method.getName() + " ожидается " + res);
            }

        }


    }
}
