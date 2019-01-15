package by.it.skarpovich.jd02_08;

import org.xml.sax.Attributes;

import org.xml.sax.helpers.DefaultHandler;

class SAXHandler extends DefaultHandler {
    private String tab;
    private StringBuilder content;

    @Override
    public void startDocument() {
        tab = "";
        content = new StringBuilder();
        System.out.println("Document Start");
    }

    @Override
    public void endDocument() {
        System.out.println("Document End");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        StringBuilder attr = new StringBuilder();
        // Начало. Добавляем атрибут в цикле (attr): xsi="http://www.w3.org/2001/XMLSchema-instance" и т.д.
        for (int i = 0; i < attributes.getLength(); i++) {
            String name = attributes.getLocalName(i);
            String value = attributes.getValue(i);
            attr.append(" ").append(name).append("=\"").append(value).append("\"");
        }
        //конец

        //Выводим название тега с атримбутом (если имеется)
        System.out.println(tab + "<" + qName + attr + ">");
        tab ="\t" + tab;    // Добавляем табуляцию
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (content.length() > 0) {
            System.out.println(tab + content);
            content.setLength(0);
        }
        tab = tab.substring(1);
        System.out.println(tab + "</" + qName + ">");
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String part = new String(ch, start, length);
        content.append(part.trim());
    }
}
