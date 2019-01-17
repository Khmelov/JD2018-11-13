package by.it.karnilava.calc;



import java.util.Date;
import java.util.Map;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
       //изменение 1
        RuntimeReport.setStartTime(new Date());
        Scanner scan = new Scanner(System.in);
        String line;
        LoggerErrors.getInstance();
        new ListofErrors();
        new TimeofErrors();
        new Director();



        Parser parser = new Parser();
        Printer printer = new Printer();

        while (!(line = scan.nextLine()).equals("end")) {
            if (line.equals("ru")||line.equals("en")||line.equals("be")){
                new SwitchLanguages(line);
                line=scan.nextLine();
            }

            if (line.equals("printvar")) {

                for (Map.Entry<String, Var> entry : Var.vars.entrySet()) {
                    System.out.println(entry.getKey() + "=" + entry.getValue());
                }

            } else if (line.equals("sortvar")) {

                for (Map.Entry<String, Var> entry : Var.sortedVars.entrySet()) {
                    System.out.println(entry.getKey() + "=" + entry.getValue());
                }

            } else {
                try {
                    if (line.contains("(")){
                       line= parser.hookcalc(line);

                    }
                    String result = parser.calc(line);
                    printer.print(result);
                } catch (CalcException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        RuntimeReport.setCancelTime(new Date());
        System.out.println("Which kind of report do yoy want to get? Insert 'short' or 'full'");
        line=scan.nextLine();
        Director.buildReport(line);
    }


}

