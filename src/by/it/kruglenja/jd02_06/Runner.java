package by.it.kruglenja.jd02_06;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Runner {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("d#");
        logger = Logger.getInstance();
        logger.log("21#");
        logger = Logger.getInstance();
        logger.log("wd#");
        logger = Logger.getInstance();
        logger.log("sdfs#");
        logger = Logger.getInstance();
        logger.log("erwew#");

        try (BufferedReader br = new BufferedReader(
                new FileReader("C:\\Users\\Tom\\IdeaProjects\\JD2018-11-13\\src\\by\\it\\kruglenja\\jd02_06\\log.txt"))
        ) {
            char[] text = new char[100];
            br.read(text);
            for (char c : text) {
                System.out.print(c);
                br.close();

        }} catch (IOException e) {
            e.printStackTrace();
        }
    }
}
