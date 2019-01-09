package by.it.mnovikov.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;


enum ResMan {
    INSTANCE;

    private ResMan() {
        setLocale(Locale.getDefault());
    }

    private ResourceBundle resourceBundle;

    public void setLocale(Locale locale) {
        resourceBundle = ResourceBundle.getBundle("by.it.mnovikov.jd02_05.res.translate", locale);
    }

    public String get(String key) {
        return resourceBundle.getString(key);
    }

    public Locale getLocale() {
        return resourceBundle.getLocale();
    }
}
