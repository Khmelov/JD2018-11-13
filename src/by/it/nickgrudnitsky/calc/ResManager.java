package by.it.nickgrudnitsky.calc;

import java.util.Locale;
import java.util.ResourceBundle;


enum ResManager {
    INSTANCE;

    private Locale locale = Locale.getDefault();

    private ResManager() {
        setLocale(Locale.getDefault());
    }

    private ResourceBundle resourceBundle;

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        resourceBundle = ResourceBundle.getBundle("by.it.nickgrudnitsky.calc.res.locale", locale);
        this.locale = locale;
    }

    public String get(String key) {
        return resourceBundle.getString(key);
    }
}
