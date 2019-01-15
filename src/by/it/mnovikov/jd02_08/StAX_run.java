package by.it.mnovikov.jd02_08;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class StAX_run {

    public static String xml = System.getProperty("user.dir") + "/src/by/it/mnovikov/jd02_08/organization.xml";

    public static void main(String[] args) {
        String tabul = "";
        StringBuilder content = new StringBuilder();


        try {
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            FileInputStream xmlFile = new FileInputStream(xml);
            XMLStreamReader reader = inputFactory.createXMLStreamReader(xmlFile);
            while (reader.hasNext()) {
                int type = reader.next();
                switch (type) {
                    case XMLStreamConstants.START_DOCUMENT:
                        System.out.println("Start");
                        break;
                    case XMLStreamConstants.ATTRIBUTE:
                        System.out.println("-------------");
                        break;
                    case XMLStreamConstants.START_ELEMENT:
                        StringBuilder att = new StringBuilder();
                        int attributeCount = reader.getAttributeCount();
                        for (int i = 0; i < attributeCount; i++) {
                            String name = reader.getAttributeLocalName(i);
                            String value = reader.getAttributeValue(i);
                            att.append(" ").append(name).append("\"").append(value).append("\"");
                        }
                        System.out.println(tabul + "<" + reader.getLocalName() + att + ">");
                        tabul = "\t" + tabul;
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        String part = reader.getText();
                        content.append(part.trim());
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        if (content.length() > 0) {
                            System.out.println(content + tabul);
                            content.setLength(0);
                        }
                        tabul = tabul.substring(1);
                        System.out.println(tabul + "<" + reader.getLocalName() + ">");
                        break;
                    case XMLStreamConstants.END_DOCUMENT:
                        System.out.println("End");
                        break;
                }
            }
        } catch (XMLStreamException | FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
