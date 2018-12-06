package by.it.nickgrudnitsky.jd01_10;

import java.lang.reflect.Method;

public class BeanTester {
    public static void main(String[] args) throws Exception {
        Class<Bean> beanClass = Bean.class;
        Object bean = beanClass.newInstance();
        Method[] methods = beanClass.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Param.class)) {
                Param annotation = method.getAnnotation(Param.class);
                double result = (double) method.invoke(bean, annotation.a(), annotation.b());
                System.out.println(method.getName() + result);
            }
        }
    }
}
