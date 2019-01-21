package by.it.lobkova.jd02_08;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class SAXRunner {

    private static String xml = System.getProperty("user.dir") + "/src/by/it/lobkova/jd02_07/person+xsd.xml";

    public static void main(String[] args) {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();
            DefaultHandler defaultHandler = new SAXHandler();
            File xmlFile = new File(xml);
            saxParser.parse(xmlFile, defaultHandler);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.getMessage();
        }
    }

}
