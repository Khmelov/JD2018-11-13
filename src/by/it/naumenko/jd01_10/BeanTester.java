package by.it.naumenko.jd01_10;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BeanTester {

    public static void main(String[] args) throws Exception {
        Class bean = Bean.class;
        Bean object = (Bean) bean.newInstance();//создание объекта
        Method[] declaredMethods = bean.getDeclaredMethods(); //все методы класса Bean
        for (Method declaredMethod : declaredMethods) {
            if (declaredMethod.isAnnotationPresent(Param.class)) { //проверка анатирован ли метод?
                Param annatation = declaredMethod.getAnnotation(Param.class);//Записать аннотацию
                double rezultat = (double) declaredMethod.invoke(object, annatation.a(), annatation.b());
                System.out.println(annatation + " " + declaredMethod.getName() + " " + rezultat);
            }
        }
    }
}
