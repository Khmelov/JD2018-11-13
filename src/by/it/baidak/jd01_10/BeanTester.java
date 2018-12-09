package by.it.baidak.jd01_10;

import java.lang.reflect.Method;

public class BeanTester {
    public static void main(String[] args) throws Exception {

        processBeanCreate(Bean.class);
    }

    static void processBeanCreate(Class<?> cls) throws Exception {

        Bean bean = (Bean) cls.newInstance();
        Method[] methods = cls.getDeclaredMethods();

        for (Method method : methods) {
            if(method.isAnnotationPresent(Param.class)){

                Param methodAnnotation = method.getAnnotation(Param.class);
                double result = (double) method.invoke(bean, methodAnnotation.a(), methodAnnotation.b());
                System.out.println(method.getName() + " " + result);
            }
        }
    }
}
