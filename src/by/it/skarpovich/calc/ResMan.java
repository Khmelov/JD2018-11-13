package by.it.skarpovich.calc;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResMan {
    INSTANCE;

    ResMan() {
        setLocale(Locale.getDefault());
    }

    private ResourceBundle resourceBundle;

    public void setLocale(Locale locale) {
        resourceBundle = ResourceBundle.getBundle("by.it.skarpovich.calc.res.translate", locale);
    }

    public String get(String key) {

        return resourceBundle.getString(key);
    }
    public Locale getLocale() {

        return resourceBundle.getLocale();
    }
}
