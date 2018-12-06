package by.it.skarpovich.jd01_10;
import java.lang.reflect.Method;

public class BeanTester extends Bean {
    public static void main(String[] args) throws Exception {
        Class cl = Class.forName("by.it.skarpovich.jd01_10.Bean");
        Object beanObject = cl.newInstance();
        
        Method[] methods = cl.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(Param.class)) {
                Param anno = method.getAnnotation(Param.class);
                double result=(double)method.invoke(beanObject, anno.a(), anno.b());
                System.out.print(method.getName()+": ");
                System.out.println(result);
            }
        }
    }
}




