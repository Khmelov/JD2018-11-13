package by.it.denisova.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;


enum ResMan {
    INSTANCE;
    private ResourceBundle resourceBundle;

    ResMan() {
        setLocale(Locale.getDefault());
    }

    public void setLocale(Locale locale) {
        resourceBundle = ResourceBundle.getBundle("by.it.denisova.jd02_05.res.translate", locale);
    }

    public String get(String key) {
        return resourceBundle.getString(key);
    }

}
