package by.it.vchernetski.calc;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleRunner {
    private static List<String> logFile = new ArrayList<>();
    private static void readLog() {
        String path = Util.getPath("log.txt");
        File log = new File(path);
        if(!log.exists()){
            try {
                log.createNewFile();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        try (BufferedReader br = new BufferedReader(new FileReader(Util.getPath("log.txt")))) {
            while (br.ready()){
                logFile.add(br.readLine()+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void saveLog(){
        String filename = Util.getPath("log.txt");
        try(PrintWriter out = new PrintWriter(new FileWriter(filename))) {
            for (int i = 0; i<logFile.size(); i++) {
                out.print(logFile.get(i));
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        readLog();
        Var.read();
        String in;
        Parcer parcer = new Parcer();
        while (!(in = sc.next()).equals("end")){
            boolean b = (in.contains("+") || in.contains("-") || in.contains("*") || in.contains("/"))&&!in.contains("{");
            try {
                String res = parcer.calc(in);

                if(logFile.size()>=50) {
                    logFile.remove(0);
                    if(in.contains("=")&& b){
                        logFile.add(in+"="+res);
                    }
                    else {
                        if (in.contains("=")) {
                            logFile.add(in + "\n");
                        } else {
                            logFile.add(in + "=" + res + "\n");
                        }
                    }
                }
                else {
                    if(in.contains("=")&& b){
                        logFile.add(in+"="+res);
                    }
                    else {
                        if (in.contains("=")) {
                            logFile.add(in + "\n");
                        } else {
                            logFile.add(in + "=" + res + "\n");
                        }
                    }
                }
                Printer.print(res);
            }
            catch (CalcException e){
                if(logFile.size()>=50) {
                    logFile.remove(0);
                    logFile.add(e.getMessage() + "\n");
                }
                else {
                    logFile.add(e.getMessage()+"\n");
                }
               e.printStackTrace();
            }
        }
        Var.save();
        saveLog();
    }
}
