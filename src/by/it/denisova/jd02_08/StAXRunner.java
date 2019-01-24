package by.it.denisova.jd02_08;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class StAXRunner {

    private static String xml = System.getProperty("user.dir") + "/src/by/it/denisova/jd02_07/english+xsd.xml";

    public static void main(String[] args) {
        String tab="";
        StringBuilder content=new StringBuilder();

        try {
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            FileInputStream xmlFile=new FileInputStream(xml);
            XMLStreamReader reader = inputFactory.createXMLStreamReader(xmlFile);
            while (reader.hasNext()){
                int type = reader.next();
                switch (type){
                    case XMLStreamConstants.START_DOCUMENT:
                        System.out.println("start");
                        break;
                    case XMLStreamConstants.ATTRIBUTE:
                        System.out.println("============================================================");
                        break;
                    case XMLStreamConstants.START_ELEMENT:
                        StringBuilder att = new StringBuilder();
                        int attributeCount = reader.getAttributeCount();
                        for (int i = 0; i < attributeCount; i++) {
                            String name = reader.getAttributeLocalName(i);
                            String value = reader.getAttributeValue(i);
                            att.append(" ").append(name).append("=\"").append(value).append("\"");
                        }
                        System.out.println(tab + "<" + reader.getLocalName() + att + ">");
                        tab = "\t" + tab;
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        String part = reader.getText();
                        content.append(part.trim());
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        if (content.length() > 0){
                            System.out.println(tab + content);
                            content.setLength(0);
                        }

                        tab = tab.substring(1);
                        System.out.println(tab + "</" + reader.getLocalName() + ">");
                        break;
                    case XMLStreamConstants.END_DOCUMENT:
                        System.out.println("end");
                        break;
                }
            }



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }

    }
}
