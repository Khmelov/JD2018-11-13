package by.it.seroglazov.jd02_06;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.*;

public class LoggerTest {

    @Test
    public void getInstance() {
        Logger logger = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        if (logger != logger2) fail();
        logger.add("тест");
    }

    @Test
    public void add() {
        Logger logger = Logger.getInstance();
        logger.add("Строка 1");
        logger.add("Строка 2");
        logger.add("Строка 3");

        try {
            List<String> strings = Files.readAllLines(
                    Paths.get(System.getProperty("user.dir"), "src/by/it/seroglazov/jd02_06/log.txt"));
            int s = strings.size();
            if (s < 3) fail();
            if (!strings.get(s-3).endsWith("Строка 1")) fail();
            if (!strings.get(s-2).endsWith("Строка 2")) fail();
            if (!strings.get(s-1).endsWith("Строка 3")) fail();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}