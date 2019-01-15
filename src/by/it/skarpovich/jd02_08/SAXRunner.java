package by.it.skarpovich.jd02_08;

import by.it.skarpovich.jd02_07.Util;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class SAXRunner {

    private static String xml= Util.getPath()+"buyers+xsd.xml";
    //public static String xml = System.getProperty("user.dir")+"/src/by/it/skarpovich/jd02_07/buyers+xsd.xml";
    public static void main(String[] args) {

        try{
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser=saxParserFactory.newSAXParser();
            DefaultHandler myHandler=new SAXHandler();
            File xmlFile=new File(xml);
            saxParser.parse(xmlFile, myHandler);

        } catch (SAXException | ParserConfigurationException | IOException e) {
            e.printStackTrace();
        }

    }
}
