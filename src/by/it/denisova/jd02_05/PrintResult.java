
package by.it.denisova.jd02_05;

import by.it.denisova.jd02_05.res.Messages;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class PrintResult {

    private static DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG,Locale.getDefault());

    private ResMan resMan = ResMan.INSTANCE;
    private Date data = new Date();


    public void print() {
        System.out.println(resMan.get(Messages.STR_WELCOME));
        System.out.println(resMan.get(Messages.STR_QUESTION));
        System.out.println(resMan.get(Messages.USER_NAME));
        System.out.println(dateFormat.format(data));
    }

    public void changeLocale(String language, String country){
       Locale locale = new Locale(language,country);
        dateFormat = DateFormat.getDateInstance(DateFormat.LONG, locale);
        resMan.setLocale(locale);


    }
}