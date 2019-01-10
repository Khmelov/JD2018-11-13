package by.it.vchernetski.calcwithpatterns;

import java.util.Locale;
import java.util.Scanner;

import static by.it.vchernetski.calcwithpatterns.Var.resMan;

public class ConsoleRunner {

    private static ReportWriter createReportWriter() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose report: 1 - full, 2 - short");
        while (true) {
            int choice = Integer.parseInt(sc.nextLine());
            if (choice < 1 || choice > 2) {
                System.out.println("Wrong input");
                continue;
            }
            switch (choice) {
                case 1:
                    return new ReportWriter(resMan.getLocale(), new ReportFullBuilder());
                case 2:
                    return new ReportWriter(resMan.getLocale(), new ReportShortBuilder());
            }
        }
    }

    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        Scanner sc = new Scanner(System.in);
        Var.read();
        String in;
        int lang = 0;
        String language;
        Parcer parcer = new Parcer();
        System.out.println("Choose your language: 1 - Беларускі; 2 - Русский; 3 - English (введите номер)");
        logger.log("Choose your language: 1 - Беларускі; 2 - Русский; 3 - English (введите номер)");
        while (true) {
            language = sc.nextLine();
            logger.log(language);
            language = language.trim();
            lang = Integer.parseInt(language);
            if (lang < 1 || lang > 3) {
                System.out.println("Wrong input");
                logger.log("Wrong input");
                continue;
            }
            switch (lang) {
                case 1:
                    resMan.setLocale(new Locale("be", "BY"));
                    break;
                case 2:
                    resMan.setLocale(new Locale("ru", "RU"));
                    break;
                case 3:
                    resMan.setLocale(new Locale("en", "EN"));
                    break;
            }
            break;
        }
        ReportWriter rw = createReportWriter();
        while (!(in = sc.nextLine()).equals("end")) {
            try {
                String res = parcer.calc(in);
                logger.log(in);
                Printer.print(res);
                logger.log(res);
                rw.addOperation("Operation: " + in + "Result" +res);
            } catch (CalcException e) {
                logger.log(e.getMessage());
                rw.addError(e);
                System.out.println(e.getMessage());
            }
        }
        logger.log("end");
        Var.save();
        rw.finishReport();
    }
}
