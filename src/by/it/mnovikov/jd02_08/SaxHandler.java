package by.it.mnovikov.jd02_08;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxHandler extends DefaultHandler {

    private String tabul;
    private StringBuilder content;

    @Override
    public void startDocument() throws SAXException {
        tabul = "";
        content = new StringBuilder();
        System.out.println("Start doc.");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End doc.");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        StringBuilder att = new StringBuilder();
        for (int i = 0; i < attributes.getLength(); i++) {
            String name = attributes.getLocalName(i);
            String value = attributes.getValue(i);
            att.append(" ").append(name).append("=\"").append(value).append("\"");
        }
        System.out.println(tabul + "<" + qName + att + ">");
        tabul = "\t" + tabul;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (content.length() > 0){
            System.out.println(tabul + content);
            content.setLength(0);
        }
        tabul = tabul.substring(1);
        System.out.println(tabul + "</" + qName + ">");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String part = new String(ch, start, length);
        content.append(part.trim());
    }
}
