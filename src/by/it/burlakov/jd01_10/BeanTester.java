package by.it.burlakov.jd01_10;

import java.lang.reflect.Method;

public class BeanTester {
    public static void main(String[] args) throws Exception {
        Class<Bean> bn = Bean.class;
        Method[] methArr = bn.getDeclaredMethods();
        for (Method m : methArr) {
            if (m.isAnnotationPresent(Param.class)) {
                System.out.println(m.getName() + " "
                        + m.invoke(bn.newInstance(),
                        m.getAnnotation(Param.class).a(),
                        m.getAnnotation(Param.class).b()
                ));
            }
        }


    }
}
