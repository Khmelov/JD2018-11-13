package by.it.zhivov.jd01_10;

import java.lang.reflect.Method;

public class BeanTester {
    public static void main(String[] args) throws Exception {
        Class<Bean> beanClass = Bean.class;//создаем объект класса Class для класса Bean
        Method[] declaredMethods = beanClass.getDeclaredMethods();//выводим в массив все методы класса Bean
        for (Method declaredMethod : declaredMethods) {
            if (declaredMethod.isAnnotationPresent(Param.class)) {//проверяем, содержит ли метод аннотацию Param
                Param annotation = declaredMethod.getAnnotation(Param.class);//выводим аннотацию
                Bean bean = beanClass.newInstance();//создаем объект класса Bean
                Object invoke = declaredMethod.invoke(bean, annotation.a(), annotation.b());//запускаем аннотированный
                // метод для этого объекта и передаем параметры из аннотации в качестве аргументов этому методу
                System.out.println(declaredMethod.getName() + " " + invoke);//выводим имя метода и его результат на печать
            }
        }
    }
}
