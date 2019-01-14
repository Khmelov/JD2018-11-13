package by.it.zhivov.jd02_08;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Runner {

    private static String xml = System.getProperty("user.dir") + "/src/by/it/zhivov/jd02_07/person+xsd.xml";

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("1-SAX;2-StAX");
        int input = in.nextInt();
        switch (input) {
            case 1:
                try {
                    SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
                    SAXParser saxParser = saxParserFactory.newSAXParser();
                    DefaultHandler myhandler = new SAXParse();
                    File xmlFile = new File(xml);
                    saxParser.parse(xmlFile, myhandler);
                } catch (ParserConfigurationException | SAXException | IOException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                STAXParse.staxParser(xml);
                break;

        }

    }
}
