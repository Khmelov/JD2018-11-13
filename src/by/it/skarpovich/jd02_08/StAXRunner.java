package by.it.skarpovich.jd02_08;

import by.it.skarpovich.jd02_07.Util;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamConstants;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class StAXRunner {
    private static String xml= Util.getPath()+"buyers+xsd.xml";
    //private static String xml = System.getProperty("user.dir") + "/src/by/it/skarpovich/jd02_07/buyers+xsd.xml";

    public static void main(String[] args) {
        String tab = "";
        StringBuilder content = new StringBuilder();

        try {
            XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
            FileInputStream xmlFile = new FileInputStream(xml);
            XMLStreamReader xmlReader = xmlInputFactory.createXMLStreamReader(xmlFile);
            while (xmlReader.hasNext()) {
                int type = xmlReader.next();
                switch (type) {
                    case XMLStreamConstants.START_DOCUMENT:
                        System.out.println("DOCUMENT START");
                        break;
                    case XMLStreamConstants.ATTRIBUTE:
                        System.out.println("============================================================");
                        break;

                    case XMLStreamConstants.START_ELEMENT:
                        StringBuilder attr = new StringBuilder();
                        int attributeCount = xmlReader.getAttributeCount();
                        for (int i = 0; i < attributeCount; i++) {
                            String name = xmlReader.getAttributeLocalName(i);
                            String value = xmlReader.getAttributeValue(i);
                            attr.append(" ").append(name).append("=\"").append(value).append("\"");
                        }

                        System.out.println(tab + "<" + xmlReader.getLocalName() + attr + ">");
                        tab = "\t" + tab;
                        break;

                    case XMLStreamConstants.CHARACTERS:
                        String part = xmlReader.getText();
                        content.append(part.trim());
                        break;

                    case XMLStreamConstants.END_ELEMENT:
                        if (content.length() > 0) {
                            System.out.println(tab + content);
                            content.setLength(0);
                        }
                        tab = tab.substring(1);
                        System.out.println(tab + "<" + xmlReader.getLocalName() + ">");
                        break;

                    case XMLStreamConstants.END_DOCUMENT:
                        System.out.println("DOCUMENT END");
                }
            }
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
    }
}
