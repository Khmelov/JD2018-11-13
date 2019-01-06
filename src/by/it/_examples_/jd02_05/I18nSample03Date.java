package by.it._examples_.jd02_05;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.*;
public class I18nSample03Date {
    public static void main(String[] args) {
        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.US);
        Date d = null;
        String str = "April 12, 2016";
        try {
            d = df.parse(str);
            System.out.println(d);
        } catch (ParseException e) {
            System.err.print("Error position: " + e.getErrorOffset());
        }
        df = DateFormat.getDateInstance(DateFormat.LONG, new Locale("ru","RU"));
        System.out.println(df.format(d));
        df = DateFormat.getDateInstance(DateFormat.FULL,Locale.GERMAN);
        System.out.println(df.format(d));
    }
}
