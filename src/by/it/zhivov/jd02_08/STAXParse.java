package by.it.zhivov.jd02_08;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class STAXParse {

    //private static String xml = System.getProperty("user.dir") + "/src/by/it/zhivov/jd02_07/person+xsd.xml";

    static void staxParser(String xml) {
        System.out.println("start StAX Parse\n");
        String tab = "";
        StringBuilder content = new StringBuilder();
        try

        {
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            FileInputStream xmlFile = new FileInputStream(xml);
            XMLStreamReader reader = inputFactory.createXMLStreamReader(xmlFile);
            while (reader.hasNext()) {
                int type = reader.next();
                switch (type) {
                    case XMLStreamConstants.START_DOCUMENT:
                        System.out.println("start xml");
                        break;
                    case XMLStreamConstants.ATTRIBUTE:
                        System.out.println("att");
                        break;
                    case XMLStreamConstants.START_ELEMENT:
                        StringBuilder atts = new StringBuilder();
                        int attCount = reader.getAttributeCount();
                        for (int i = 0; i < attCount; i++) {
                            String key = reader.getAttributeLocalName(i);
                            String value = reader.getAttributeValue(i);
                            atts.append(" ").append(key).append("=\"").append(value).append("\"");
                        }
                        System.out.println(tab + "<" + reader.getLocalName() + atts + ">");
                        tab = "\t" + tab;
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        String part = reader.getText();
                        content.append(part.trim());
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        if (content.length() > 0) {
                            System.out.println(tab + content);
                            content.setLength(0);
                        }
                        tab = tab.substring(1);
                        System.out.println(tab + "</" + reader.getLocalName() + ">");
                        break;
                    case XMLStreamConstants.END_DOCUMENT:
                        //System.out.println("end xml");
                        break;
                }
            }

        } catch (FileNotFoundException |
                XMLStreamException e)

        {
            e.printStackTrace();
        }
    }

}
