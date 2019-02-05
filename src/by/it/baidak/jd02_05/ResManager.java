package by.it.baidak.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;


enum ResManager {

    INSTANCE;

    private ResManager() {
        setLocale(new Locale("en", "EN"));
    }

    private ResourceBundle resourceBundle;

    public void setLocale(Locale locale) {
        resourceBundle = ResourceBundle.getBundle("by.it.baidak.jd02_05.res.translate", locale);

    }

    public String get(String key) {
        return resourceBundle.getString(key);
    }
}
