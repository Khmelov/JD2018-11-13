package by.it.kovalyova.jd02_08;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class SAXRunner {

    private static String xml= System.getProperty("user.dir")+"/src/by/it/kovalyova/jd02_07/flat.xml";


    public static void main(String[] args) {

        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            DefaultHandler ourHandler = new SAXHandler();
            File xmlFile = new File(xml);
            saxParser.parse(xmlFile, ourHandler);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

    }
}




