package by.it.denisova.jd02_08;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class SAXRunner {

    private static String xml = System.getProperty("user.dir") + "/src/by/it/denisova/jd02_07/english+xsd.xml";

    public static void main(String[] args) {

     try {
         SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
         SAXParser saxParser = saxParserFactory.newSAXParser();
    }
      catch (SAXException e) {
         e.printStackTrace();
     } catch (ParserConfigurationException e) {
         e.printStackTrace();
     }
    }
}
