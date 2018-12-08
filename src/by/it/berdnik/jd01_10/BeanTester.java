package by.it.berdnik.jd01_10;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BeanTester {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Class bean = Bean.class;
        Object x = bean.newInstance();
        Method[] met = bean.getDeclaredMethods();
        for (Method mt : met) {
            if (mt.isAnnotationPresent(Param.class)) {
                Param pam = mt.getAnnotation(Param.class);
                double res = (double) mt.invoke(x, pam.a(), pam.b());
                System.out.println(mt.getName() + " " + res);
            }
        }
    }
}
