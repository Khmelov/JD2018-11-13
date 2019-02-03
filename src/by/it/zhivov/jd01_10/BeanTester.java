package by.it.zhivov.jd01_10;

import java.lang.reflect.Method;

public class BeanTester {
    public static void main(String[] args) throws Exception {
        Class<Bean> beanClass = Bean.class;
        Method[] declaredMethods = beanClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            if (declaredMethod.isAnnotationPresent(Param.class)) {
                Param annotation = declaredMethod.getAnnotation(Param.class);
                Bean bean = beanClass.newInstance();
                Object invoke = declaredMethod.invoke(bean, annotation.a(), annotation.b());
                System.out.println(declaredMethod.getName() + " " + invoke);
            }
        }
    }
}
