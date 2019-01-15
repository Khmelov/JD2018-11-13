package by.it.markelov.jd02_08;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyHandler extends DefaultHandler {
    private String tab;
    private StringBuilder content;

    @Override
    public void startDocument() throws SAXException {
        content = new StringBuilder();
        tab = "";
        System.out.println("Start parse XML-document...");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End parse XML-document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        StringBuilder attributesOfElement = new StringBuilder();
        for (int i = 0; i < attributes.getLength(); i++) {
            String nameOfAttribute = attributes.getLocalName(i);
            String valueOfAttribute = attributes.getValue(i);
            attributesOfElement.append(nameOfAttribute).append("=").append("\"").append(valueOfAttribute).append("\"");
        }
        System.out.println(tab + "<" + qName + "" + attributesOfElement + ">");
        tab += "\t";
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
        String partOfContent = new String(ch, start, length);
        content.append(partOfContent.trim());
    }
}
