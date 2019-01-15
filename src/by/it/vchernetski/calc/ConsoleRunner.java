package by.it.vchernetski.calc;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import static by.it.vchernetski.calc.Var.resMan;

public class ConsoleRunner {
    private static List<String> logFile = new ArrayList<>();

    private static void readLog() {
        String path = Util.getPath("log.txt");
        File log = new File(path);
        if (!log.exists()) {
            try {
                log.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try (BufferedReader br = new BufferedReader(new FileReader(Util.getPath("log.txt")))) {
            while (br.ready()) {
                logFile.add(br.readLine() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void saveLog() {
        String filename = Util.getPath("log.txt");
        try (PrintWriter out = new PrintWriter(new FileWriter(filename))) {
            for (int i = 0; i < logFile.size(); i++) {
                out.print(logFile.get(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        readLog();
        Var.read();
        String in;
        int lang = 0;
        String language;
        Parcer parcer = new Parcer();
        System.out.println("Choose your language: 1 - Беларускі; 2 - Русский; 3 - English (введите номер)");
        while (true) {
            language = sc.nextLine();
            language = language.trim();
            lang = Integer.parseInt(language);
            if(lang < 1 || lang > 3){
                System.out.println("Wrong input");
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
        while (!(in = sc.nextLine()).equals("end")) {
            boolean b = (in.contains("+") || in.contains("-") || in.contains("*") || in.contains("/")) && !in.contains("{");
            try {
                String res = parcer.calc(in);
                if (logFile.size() >= 50) {
                    logFile.remove(0);
                    if (in.contains("=") && b) {
                        logFile.add(in + "=" + res);
                    } else {
                        if (in.contains("=")) {
                            logFile.add(in);
                        } else {
                            logFile.add(in + "=" + res);
                        }
                    }
                } else {
                    if (in.contains("=") && b) {
                        logFile.add(in + "=" + res);
                    } else {
                        if (in.contains("=")) {
                            logFile.add(in + "\n");
                        } else {
                            logFile.add(in + "=" + res + "\n");
                        }
                    }
                }
                Printer.print(res);
            } catch (CalcException e) {
                if (logFile.size() >= 50) {
                    logFile.remove(0);
                    logFile.add(e.getMessage() + "\n");
                } else {
                    logFile.add(e.getMessage() + "\n");
                }
                System.out.println(e.getMessage());
            }
        }
        Var.save();
        saveLog();
    }
}
