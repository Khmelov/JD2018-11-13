package by.it.vchernetski.calcwithpatterns;

import java.util.Locale;
import java.util.ResourceBundle;

enum ResMan {
    INSTANCE;
    Locale locale;
    ResMan(){setLocale(Locale.getDefault());}
    private ResourceBundle resourceBundle;
    public void setLocale(Locale locale){
        this.locale = locale;
        resourceBundle = ResourceBundle.getBundle("by/it/vchernetski/calc/errors/errors",locale);
    }
    public String get(String key){return resourceBundle.getString(key);}
    public Locale getLocale(){return locale;}
}
