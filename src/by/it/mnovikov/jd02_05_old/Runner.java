package by.it.mnovikov.jd02_05_old;


import by.it.mnovikov.jd02_05_old.res.Messages;

import java.util.Locale;

/**
 * Created by user on 05.01.2019.
 */
public class Runner {
//    @Test
//    public void go() {
//        System.out.println("hi");
//    }

    public static void main(String[] args) {
        ResMan resMan = ResMan.INSTANCE;
        Locale locale = new Locale("be", "BY");
        resMan.setLocale(locale);
        System.out.println(resMan.get(Messages.STR_WELCOME));
        System.out.println(resMan.get(Messages.STR_QUESTION));
        System.out.println(resMan.get(Messages.USER_NAME));
    }
}
