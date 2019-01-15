package by.it.naumenko.jd02_08;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxHendler extends DefaultHandler {

    String tab;
    StringBuilder counter;
    @Override
    public void startDocument() throws SAXException {

        tab="";
        counter=new StringBuilder();
        System.out.println("Старт документа");
        super.startDocument();
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("конец документа");
        super.endDocument();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
    }
}
