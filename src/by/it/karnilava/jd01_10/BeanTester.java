package by.it.karnilava.jd01_10;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class BeanTester {
    public static void main(String[] args) throws Exception {
        Class<Bean> beanClass = Bean.class;
        Object bean=beanClass.newInstance();

        Method[] methods = beanClass.getDeclaredMethods();

        for(Method method: methods){
            if ( method.isAnnotationPresent(Param.class)){
                Param ann=method.getAnnotation(Param.class);

                Object result = method.invoke(bean,ann.a(),ann.b());
                System.out.print(method.getName()+" ");
                System.out.println(result);
            }
        //

        }
    }
}
