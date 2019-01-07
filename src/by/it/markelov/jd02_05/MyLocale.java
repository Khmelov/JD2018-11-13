package by.it.markelov.jd02_05;

import java.util.Locale;

public class MyLocale {
    private Locale localeDefault =Locale.getDefault();
    private Locale localeRU=new Locale("ru", "RU");
    private Locale localeBE=new Locale("be", "BE");

    public Locale getLocaleDefault() {
        return localeDefault;
    }

    public Locale getLocaleRU() {
        return localeRU;
    }

    public Locale getLocaleBE() {
        return localeBE;
    }
}
