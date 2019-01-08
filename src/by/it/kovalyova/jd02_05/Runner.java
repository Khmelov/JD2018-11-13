package by.it.kovalyova.jd02_05;

import by.it.kovalyova.jd02_05.res.Messages;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

public class Runner {
    private static Locale newlocale(String[] args) {
        Locale l;
        if (args.length >= 2) {
            return new Locale(args[0],args[1]);
        } else {
            return new Locale(args[0]);
        }
    }
    private static void exec(String cmd) {
        ProcessBuilder builder = new ProcessBuilder(cmd);
        try {

            final Process process = builder.start();
            InputStream is = process.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("Program terminated!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        exec("native2ascii");

        ResMan resMan = ResMan.INSTANCE;
        Locale locale;
        if (args.length >= 1) {
            locale = newlocale(args);
            System.out.println(locale);
        } else {
            locale = Locale.getDefault();
        }
        resMan.setLocale(locale);
        System.out.println(resMan.get(Messages.STR_WELCOME));
        System.out.println(resMan.get(Messages.STR_QUESTION));
        System.out.println(resMan.get(Messages.USER_NAME));
        Calendar cal = Calendar.getInstance();
        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, locale);
        System.out.println(df.format(cal.getTime()));
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] sa = new String[]{s};
        locale = newlocale(sa);
        resMan.setLocale(locale);
        System.out.println(resMan.get(Messages.STR_WELCOME));
        System.out.println(resMan.get(Messages.STR_QUESTION));
        System.out.println(resMan.get(Messages.USER_NAME));
        df = DateFormat.getDateInstance(DateFormat.FULL, locale);
        System.out.println(df.format(cal.getTime()));

    }
}
