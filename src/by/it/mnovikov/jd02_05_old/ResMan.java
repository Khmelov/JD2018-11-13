package by.it.mnovikov.jd02_05_old;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by user on 05.01.2019.
 */
enum ResMan {
    INSTANCE;

    ResMan() {
        setLocale(Locale.getDefault());
    }

    private ResourceBundle resourceBundle;

    public void setLocale(Locale locale) {
        resourceBundle = ResourceBundle.getBundle("by.it.mnovikov.jd02_05.res.Translate", locale);
    }

    public String get(String key) {
        return resourceBundle.getString(key);
    }
}
