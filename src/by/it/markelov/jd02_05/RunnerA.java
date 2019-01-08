package by.it.markelov.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public class RunnerA {
    public static void main(String[] args) {
        ResourceBundle resourceBundle;
        if (args.length >= 2) {
            Locale locale = new Locale(args[0], args[1]);
            resourceBundle = ResourceBundle.getBundle("by.it.markelov.jd02_05.MyResources", locale);
        } else {
            Locale.setDefault(new Locale("en", "EN"));
            resourceBundle = ResourceBundle.getBundle("by.it.markelov.jd02_05.MyResources", Locale.getDefault());
        }
        System.out.println(resourceBundle.getString(Fields.getWELCOME()));
        System.out.println(resourceBundle.getString(Fields.getINTRODUCE()));
        System.out.println(resourceBundle.getString(Fields.getNAME()));
    }
}
