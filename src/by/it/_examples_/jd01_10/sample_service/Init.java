package by.it._examples_.jd01_10.sample_service;

import java.lang.annotation.*;

@Inherited  //эта аннотация наследуется потомками помеченного класса
@Target(ElementType.METHOD) //эта аннотация предназначена для пометки метода класса
@Retention(RetentionPolicy.RUNTIME) //аннотация живет при выполнении

public @interface Init {
    //задача такова. Нужно написать аннотации Init+Service.
    //какой-то код (наш фреймворк) ищет все классы Service и если они не lazyLoad то
    //в них ищет методы Init
    //запускает их, и обрабатывает исключения, так как сказано в аннотации
    boolean suppressException() default false;
}
