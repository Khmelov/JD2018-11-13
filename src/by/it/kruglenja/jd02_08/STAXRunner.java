package by.it.kruglenja.jd02_08;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class STAXRunner {
    private static String xml = System.getProperty("user.dir") + "\\src\\by\\it\\kruglenja\\jd02_07\\spareparts\\spareparts.xml";

    public static void main(String[] args) {
        String tab = "";
        StringBuilder content = new StringBuilder();

        try {
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            FileInputStream xmlFile = new FileInputStream(xml);
            XMLStreamReader sr = inputFactory.createXMLStreamReader(xmlFile);
            while (sr.hasNext()) {
                int type = sr.next();
                switch (type) {
                    case XMLStreamConstants.START_DOCUMENT:
                        System.out.println("start");
                        break;
                    case XMLStreamConstants.ATTRIBUTE:
                        System.out.println("attribute");
                        break;
                    case XMLStreamConstants.START_ELEMENT:
                        StringBuilder atr = new StringBuilder();
                        int atribCount = sr.getAttributeCount();
                        for (int i = 0; i < atribCount; i++) {
                            String name = sr.getAttributeLocalName(i);
                            String value = sr.getAttributeValue(i);
                            atr.append(" ").append(name).append("=\"").append(value).append("\"");
                        }
                        System.out.println(tab + "<" + sr.getLocalName() + atr + ">");
                        tab = "\t" + tab;
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        String part = sr.getText();
                        content.append(part.trim());
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        if (content.length() > 0) {
                            System.out.println(tab + content);
                            content.setLength(0);
                        }
                        tab = tab.substring(1);
                        System.out.println(tab + "</" + sr.getLocalName() + ">");
                        break;
                    case XMLStreamConstants.END_DOCUMENT:
                        System.out.println("finish");
                        break;

                }
            }
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
    }
}
