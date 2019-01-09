package by.it._examples_.jd02_05.date_and_time;

import org.junit.Test;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Java8API {
    //что мы все psvm да psvm. Тесты же уже знаем.
    //ок. Давайте ими и будем пользоваться аки psvm. Хватит одной аннотации
    @Test
    public void go() throws InterruptedException {
        Clock clock=Clock.systemDefaultZone(); //тут много способов
        System.out.println(clock.millis());
        System.out.println(clock.instant());
        //но часы это не Date они идут
        Thread.sleep(1500);
        System.out.println(clock.millis());
        //метка времени
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);
        //наконец самый строгий класс (но зато безошибочный)
        ZonedDateTime zdt = ZonedDateTime.of(ldt, ZoneId.of("Europe/Moscow"));
        System.out.println(zdt);
    }
}
