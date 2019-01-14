package by.it.nickgrudnitsky.jd02_08;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class ExampleSAX extends DefaultHandler {
    public static void main(String[] args) {
        try {
            String fileName = "src/by/it/nickgrudnitsky/jd02_07/twitch+xsd.xml";

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            ExampleSAX exampleSAX = new ExampleSAX();
            parser.parse(new File(fileName), exampleSAX);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.println("ERROR:" + e.toString());
        }

    }


    private String tab = "";
    private StringBuilder value = new StringBuilder();
    @Override
    public void startDocument() throws SAXException {
        System.out.println("Начало обработки");;
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Конец обработки");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.print(tab + "<" + qName);
        for (int i = 0; i < attributes.getLength(); i++) {
            String name = attributes.getLocalName(i);
            String value = attributes.getValue(i);
            System.out.print(" " + name + "=\""+ value + "\"");
        }
        System.out.println(">");
        tab = '\t' + tab;
        value.setLength(0);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (value.length() != 0 ) {
            System.out.println(tab + value);
        }
        value.setLength(0);
        tab = tab.substring(1);
        System.out.println(tab + "</" + qName + ">");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        value = value.append(new String(ch, start, length).trim());
    }
}
