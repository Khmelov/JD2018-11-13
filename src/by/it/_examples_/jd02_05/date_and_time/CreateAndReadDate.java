package by.it._examples_.jd02_05.date_and_time;

import java.util.Calendar;
import java.util.Date;

public class CreateAndReadDate {
    public static void main(String[] args) {
        // Задаем количество миллисекунд Unix-time
        Date moment = new Date(1546617048666L);
        // Узнаем количество миллисекунд и просто печатаем время
        System.out.println("1. " + moment.getTime() + " или " + moment);

        //построим дату через Calendar.
        //Calendar.getInstance() выберет Buddhist/JapaneseImperial/GregorianCalendar
        Calendar calendar = Calendar.getInstance();
        // Странность. Месяцы с 0 а даты с 1
        calendar.set(2019, Calendar.JANUARY, 4, 18, 50, 48);
        moment = calendar.getTime();
        // Узнаем количество миллисекунд и просто печатаем время.
        // Странность. Как видим миллисекунды не обнуляются
        System.out.println("2. " + moment.getTime() + " или " + moment);
        // Они берутся от текущего момента или от предыдущего состояния
        calendar.set(2019, 0, 4, 18, 50, 48);
        moment = calendar.getTime();
        System.out.println("3. " + moment.getTime() + " или " + moment);

    }
}
