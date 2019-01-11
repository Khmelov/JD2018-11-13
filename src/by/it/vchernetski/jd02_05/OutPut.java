package by.it.vchernetski.jd02_05;

import by.it.vchernetski.jd02_05.res.Messages;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class OutPut {
    private ResMan resMan = ResMan.INSTANCE;
    private DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG,Locale.getDefault());
    private Date date = new Date();
    private Locale locale;
    public void Print() {
        System.out.println(dateFormat.format(date));
        System.out.println(resMan.get(Messages.STR_WELCOM));
        System.out.println(resMan.get(Messages.STR_QUESTION));
        System.out.println(resMan.get(Messages.USER_Name));
    }
    public void changeLocale(String language, String country){
        locale = new Locale(language,country);
        dateFormat=DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG,locale);
        resMan.setLocale(locale);
    }
    public void wrongCommand(){
        System.out.println(resMan.get(Messages.COMMAND));
    }
}
//