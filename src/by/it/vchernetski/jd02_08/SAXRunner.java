package by.it.vchernetski.jd02_08;

import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class SAXRunner {
    private static String xml = System.getProperty("user.dir") + "/src/by/it/vchernetski/jd02_07/Drivers+xsd.xml";

    public static void main(String[] args) {
        try{
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();
            DefaultHandler myHandler = new MySAX();
            File xmlfile = new File(xml);
            saxParser.parse(xmlfile,myHandler);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
