package by.it.zakharenko.jd02_05;

import by.it.zakharenko.jd02_05.res.Messages;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class PrintResult {

    private DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG,Locale.getDefault());
    private Locale locale;
    private ResMan resMan = ResMan.INSTANCE;
    private Date data = new Date();


    public void Print() {
        System.out.println(resMan.get(Messages.STR_WELCOME));
        System.out.println(resMan.get(Messages.STR_QUESTION));
        System.out.println(resMan.get(Messages.USER_NAME));
        System.out.println(dateFormat.format(data));
    }

    public void changeLocale(String language, String country){
        locale = new Locale(language,country);
        dateFormat = DateFormat.getDateInstance(DateFormat.LONG, locale);
        resMan.setLocale(locale);

    }
}
