package by.it.markelov.jd02_08;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class MySAXParser {
    public static void main(String[] args) {
        MyHandler myHandler = new MyHandler();
        File fileToParse = new File(Path.pathOfThisDirectory(MySAXParser.class) + File.separator + "clients.xml");

        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser();
            saxParser.parse(fileToParse, myHandler);
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}
