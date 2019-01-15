package by.it.seroglazov.calc;

import java.util.Locale;
import java.util.ResourceBundle;

class ResMan {

    private ResMan() {
    }

    private static String textResPath = "by.it.seroglazov.calc.res.text";

    // В этой строке будет автоматичски подключена дефолтная локаль из JVM
    private static ResourceBundle rb = ResourceBundle.getBundle(textResPath);

    static void changeLanguage(Locale loc) {
        rb = ResourceBundle.getBundle(textResPath, loc);
        locale = loc;
    }

    static String get(String key) {
        return rb.getString(key);
    }

    static Locale getLocale() {
        return locale;
    }

    private static Locale locale = Locale.getDefault();

}
