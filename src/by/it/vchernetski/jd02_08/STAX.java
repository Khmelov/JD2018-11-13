package by.it.vchernetski.jd02_08;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;

public class STAX {
    private static String xml = System.getProperty("user.dir") + "/src/by/it/vchernetski/jd02_07/Drivers+xsd.xml";

    public static void main(String[] args) {
        String tab = "";
        StringBuilder content = new StringBuilder();
        FileInputStream xmlFile = null;
        XMLStreamReader in = null;
        try {
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            xmlFile = new FileInputStream(xml);
            in = inputFactory.createXMLStreamReader(xmlFile);
            while (in.hasNext()) {
                int type = in.next();
                switch (type) {
                    case XMLStreamConstants.START_DOCUMENT:
                        System.out.println("Start");
                        break;
                    case XMLStreamConstants.ATTRIBUTE:
                        System.out.println("==================================");
                        break;
                    case XMLStreamConstants.START_ELEMENT:
                        int countAtt = in.getAttributeCount();
                        StringBuilder att = new StringBuilder();
                        for (int i = 0; i < countAtt; i++) {
                            String name = in.getAttributeLocalName(i);
                            String value = in.getAttributeValue(i);
                            att.append(" ").append(name).append("=\"").append(value).append("\"");
                        }
                        System.out.println(tab + "<" + in.getLocalName() + att + ">");
                        tab = "\t" + tab;
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        String part = in.getText();
                        content.append(part.trim());
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        if (content.length() > 0) {
                            System.out.println(tab + content);
                            content.setLength(0);
                        }
                        tab = tab.substring(1);
                        System.out.println(tab + "</" + in.getLocalName() + ">");
                        break;
                    case XMLStreamConstants.END_DOCUMENT:
                        System.out.println("end");
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (in != null) in.close();
                if (xmlFile != null) xmlFile.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
