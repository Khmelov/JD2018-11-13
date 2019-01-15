package by.it.zhivov.jd02_08;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXParse extends DefaultHandler {


    private String tab;
    private StringBuilder content;

    @Override
    public void startDocument() throws SAXException {
        System.out.println("start SAX Parse\n");
        tab="";
        content=new StringBuilder();
    }

    @Override
    public void endDocument() throws SAXException {
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        StringBuilder atts = new StringBuilder();
        for (int i = 0; i < attributes.getLength(); i++) {
            String key = attributes.getLocalName(i);
            String value = attributes.getValue(i);
            atts.append(" ").append(key).append("=\"").append(value).append("\"");
        }
        System.out.println(tab + "<" + qName + atts + ">");
        tab = "\t" + tab;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (content.length() > 0) {
            System.out.println(tab + content);
            content.setLength(0);
        }
        tab = tab.substring(1);
        System.out.println(tab + "</" + qName + ">");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String part = new String(ch, start, length);
        content.append(part.trim());
    }
}

