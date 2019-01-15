package by.it.mnovikov.jd02_08;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class SAX_run {

    private static String xml = System.getProperty("user.dir") + "/src/by/it/mnovikov/jd02_08/organization+xsd.xml";

    public static void main(String[] args) {

        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();
            DefaultHandler ourHandler = new SaxHandler();
            File xmlFile = new File(xml);
            saxParser.parse(xmlFile, ourHandler);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}