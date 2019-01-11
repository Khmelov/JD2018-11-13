package by.it.kruglenja.jd02_05;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

enum ResMan {
    INSTANCE;

    private ResMan() {
        setLocale(Locale.getDefault());
    }

    private ResourceBundle resourceBundle;
    private DateFormat df;
//    private Calendar calendar;
    Date moment;


    public void setLocale(Locale locale) {
        resourceBundle = ResourceBundle.getBundle("by.it.kruglenja.jd02_05.res.translate", locale);
        df = DateFormat.getDateInstance(DateFormat.FULL, locale);
//        calendar = Calendar.getInstance(locale);
//        moment = calendar.getTime();
    }

    public String get(String key) {return resourceBundle.getString(key);}
    public String getDate() {return df.format(new Date());}
//    public Date getTime() {return moment;}

}
