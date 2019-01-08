package by.it._examples_.jd02_05.date_and_time;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class TimeZoneSample {
    public static void main(String[] args) {
        //Date ВНУТРИ хранит ТОЛЬКО GMT+0!!!

        //Но в Calendar по умолчанию устанавливается TimeZone.getDefault()
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getTimeZone());
        System.out.println(calendar.getTimeZone().getDisplayName());
        calendar.set(1970, Calendar.JANUARY, 1, 0, 0, 0);
        Date moment = calendar.getTime();
        // Получим в Date НГ по Минску
        System.out.println("1. " + moment.getTime() + " или " + moment);

        //сменим зону
        calendar.setTimeZone(TimeZone.getTimeZone("GMT+0"));
        System.out.println(calendar.getTimeZone());
        System.out.println(calendar.getTimeZone().getDisplayName());
        calendar.set(1970, Calendar.JANUARY, 1, 0, 0, 0);
        moment = calendar.getTime();
        // Получим в Date НГ по Unix-Time
        System.out.println("2. " + moment.getTime() + " или " + moment);

    }
}
