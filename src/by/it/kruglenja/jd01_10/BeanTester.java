package by.it.kruglenja.jd01_10;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BeanTester {
    public static void main(String[] args) throws Exception{
        Class beans = Bean.class;
        Object beanO = beans.newInstance();
        Method[] methods = beans.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Param.class)) {
                Param annotation = method.getAnnotation(Param.class);
                double out;
                out = (double) method.invoke(beanO,annotation.a(), annotation.b());
                System.out.println(method.getName() + " " + out);
            }
        }
    }
}
