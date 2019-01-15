package by.it.medvedeva.jd02_08;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

class SAXHandler extends DefaultHandler {

    private String tab;
    private StringBuilder content;

    @Override
    public void startDocument() throws SAXException {
        tab = "";
        content = new StringBuilder();
        System.out.println("Start document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        StringBuilder att = new StringBuilder();
        for (int i = 0; i < attributes.getLength(); i++) {
            String name = attributes.getLocalName(i);
            String value = attributes.getValue(i);
            att.append(" ").append(name).append("=\"").append(value).append("\"");
        }
        System.out.println(tab + "<" + qName + att + ">");
        tab = "\t" + tab;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (content.length() > 0){
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
