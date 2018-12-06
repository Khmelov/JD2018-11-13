package by.it.vchernetski.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class BeanTester {
    public static void main(String[] args) throws Exception{
        Class<Bean> beanClass = Bean.class;
        Class<Param> paramClass = Param.class;
        Bean obj = beanClass.newInstance();
        Method[] methods = beanClass.getDeclaredMethods();
        for (Method method : methods) {
            if(method.isAnnotationPresent(paramClass)) {
                Param anno = method.getDeclaredAnnotation(paramClass);
                int modifier  = method.getModifiers();
                double res;
                if(Modifier.isStatic(modifier)) {
                    res = (double) method.invoke(null, anno.a(),anno.b());
                }
                else{
                    res = (double) method.invoke(obj, anno.a(),anno.b());
                }
                System.out.println(method.getName()+" "+res);
            }
        }
    }
}
