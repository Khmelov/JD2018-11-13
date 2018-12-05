package by.it.seroglazov.jd01_10;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class BeanTester {
    public static void main(String[] args) throws Exception {
        Class bean = Bean.class;
        Object b = bean.newInstance();
        Method[] mets = bean.getDeclaredMethods();
        for (Method met : mets) {
            if (met.isAnnotationPresent(Param.class)){
                Param ann = met.getAnnotation(Param.class);
                double out = (double) met.invoke(b, ann.a(), ann.b());
                System.out.println(met.getName() + " " + out);
            }
        }
    }
}
