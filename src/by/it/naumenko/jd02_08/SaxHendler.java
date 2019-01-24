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
        StringBuilder att=new StringBuilder();
        for (int i = 0; i < attributes.getLength(); i++) {
            String name = attributes.getLocalName(i);
            String value = attributes.getValue(i);
            att.append(" ").append(name).append("=\"").append(value).append("=\"");

        }
        System.out.println(tab + "<" + qName + att + ">");
        tab="\t"+tab;
        super.startElement(uri, localName, qName, attributes);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String part = new String(ch,start,length);
        counter.append(part.trim());
        super.characters(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (counter.length()>0){
            System.out.println(tab + counter);
            counter.setLength(0);
        }
        tab=tab.substring(1);
        System.out.println(tab + "</" + qName + ">");
        super.endElement(uri, localName, qName);
    }
}
