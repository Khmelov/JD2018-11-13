package by.it.naumenko.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

enum ResourceManager {
    INSTANCE;

    private ResourceManager(){setLocale(Locale.getDefault());}

    private ResourceBundle resourceBundle;

    public void setLocale(Locale locale){
        resourceBundle = ResourceBundle.getBundle("by.it.naumenko.jd02_05.text", locale);
    }

    public String get(String key){
        return resourceBundle.getString(key);
    }
}
