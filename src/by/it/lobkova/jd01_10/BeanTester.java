package by.it.lobkova.jd01_10;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class BeanTester {
    public static void main(String[] args) throws Exception {
        Class<Bean> bean = Bean.class;
        Class<? extends Annotation> anno = Param.class;
        Method a = anno.getMethod("a");
        Method b = anno.getMethod("b");
        Method[] methods = bean.getDeclaredMethods();
        Object instance = bean.getDeclaredConstructor().newInstance();
        for (Method method : methods) {
            if (method.isAnnotationPresent(anno)) {
                Annotation annotation = method.getAnnotation(anno);
                int aValue = (int) a.invoke(annotation);
                int bValue = (int) b.invoke(annotation);
                String name = method.getName();
                double result;
                if ((method.getModifiers() & Modifier.STATIC) == Modifier.STATIC) {
                    result = (double) method.invoke(null, aValue, bValue);
                } else {
                    result = (double) method.invoke(instance, aValue, bValue);
                }
                System.out.println("Для " + method.getName() + " ожидается " + result);

            }
        }
    }
}
