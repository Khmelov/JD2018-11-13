package by.it.vchernetski.jd02_05;

import by.it.vchernetski.jd02_05.res.Messages;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class Runner {
    public static void main(String[] args) {
        ResMan resMan = ResMan.INSTANCE;
        if(args.length>=2) resMan.setLocale(new Locale(args[0],args[1]));
        System.out.println(resMan.get(Messages.STR_WELCOM));
        System.out.println(resMan.get(Messages.STR_QUESTION));
        System.out.println(resMan.get(Messages.USER_Name));
    }
}
