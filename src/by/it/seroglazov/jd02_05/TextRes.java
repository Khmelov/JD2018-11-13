package by.it.seroglazov.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

class TextRes {

    private TextRes(){
    }

    private static ResourceBundle rb = ResourceBundle.getBundle(MyConst.textResPath);

    static void changeLanguage(Locale loc){
        rb = ResourceBundle.getBundle(MyConst.textResPath, loc);
    }

    static String get(text t){
        String key;
        switch (t) {
            case WELCOME: key = "text.welcome"; break;
            case HOW_DO_YOU_DO: key = "text.howDoYouDo";break;
            case UNKNOWN_COMMAND: key = "text.unknownCommand"; break;
            case LANGUAGE_CHANGED: key = "text.languageChanged"; break;
            default: key = "";
        }
        return rb.getString(key);
    }


    @SuppressWarnings("SameParameterValue")
    static String get(user t){
        String key;
        switch (t) {
            case NAME: key = "user.name"; break;
            default: key = "";
        }
        return rb.getString(key);
    }

    enum text {
        WELCOME, HOW_DO_YOU_DO, UNKNOWN_COMMAND, LANGUAGE_CHANGED
    }

    enum user {
        NAME
    }

}
