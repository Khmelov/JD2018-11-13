package by.it._examples_.jd01_10.sample_service;

import java.lang.reflect.Method;

public class AnnotationProcess {
    public static void main(String[] args) {
        processServiceCreate(SimpleService.class);
        processServiceCreate(LazyService.class);
        processServiceCreate(Integer.class);
        //еще можно так получить классы
        //Integer i=0; i.getClass;
        //или так Class.forName("java.lang.Integer");
    }

    private static void processServiceCreate(Class<?> cls){
        if (cls.isAnnotationPresent(Service.class)){      //поверим есть ли аннотация
            Service ann=cls.getAnnotation(Service.class); //получили саму аннотацию

            cls.getAnnotations();               //все аннотации класса и его суперклассов
            cls.getDeclaredAnnotations();       //все аннотации самого класса

            System.out.println("Поле в Service аннотации name="+ann.name());
            System.out.println("Поле в Service аннотации lazyLoad="+ann.lazyLoad());
            //если есть аннотация то создадим объект этого НЕИЗВЕСТНОГО класса
            if (!ann.lazyLoad())
            try {
                Method[] methods=cls.getMethods();
                Object o=null;
                for (Method m:methods) { //ищем метод init и если он есть, то создаем экземпляр класса
                    if (m.isAnnotationPresent(Init.class))
                    {
                        if (o==null)
                            o=cls.getDeclaredConstructor().newInstance();      //создали экземпляр класса  помеченного @Service
                        m.invoke(o);                  //вызывали метод помеченный @Init
                        Init init=m.getAnnotation(Init.class);
                        boolean suppressError=init.suppressException();
                        System.out.println("Подавление ошибок: "+suppressError);
                    }
                }
                //что еще? Рефлексия - полный доступ к данным класса. Можно многое сделать и получить.
                cls.getName();       //полное имя
                cls.getSimpleName(); //только имя
                cls.getModifiers();  //модификаторы доступа
                cls.getSuperclass(); //родитель
                cls.getInterfaces(); //получили интерфейсы класса
                //получим публичные поля конструкторы и методы класса и его суперклассов
                cls.getMethods(); cls.getConstructors(); cls.getFields();
                //получим ВСЕ поля конструкторы и методы самого класса
                cls.getDeclaredMethods(); cls.getDeclaredConstructors(); cls.getDeclaredFields();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else
            System.out.println("Нет аннотации Service в классе "+cls.getName());
    System.out.println("----------------------");
    }

}
