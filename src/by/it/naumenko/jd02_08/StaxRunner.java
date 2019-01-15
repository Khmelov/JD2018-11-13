package by.it.naumenko.jd02_08;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.IOException;

public class StaxRunner {
    static String xml = System.getProperty("user.dir") + "/src/by/it/naumenko/jd02_07/saleOfCakes+xsd.xml";

    public static void main(String[] args) {
        String tab="";
        StringBuilder content=new StringBuilder();

        try {
//            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
//            SAXParser saxParser = saxParserFactory.newSAXParser();
//            DefaultHandler ourHandler=new SaxHendler();
//            File xmlFile= new File(xml);
//            saxParser.parse(xmlFile,ourHandler);
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            FileInputStream xmlFile = new FileInputStream(xml);
            XMLStreamReader xmlStreamReader = inputFactory.createXMLStreamReader(xmlFile);
            while (xmlStreamReader.hasNext()){
                int type = xmlStreamReader.next();
                switch (type){
                    case XMLStreamConstants.START_DOCUMENT:
                        System.out.println("strt");
                        break;
                    case XMLStreamConstants.ATTRIBUTE:
                        System.out.println("===========================");
                        break;
                    case XMLStreamConstants.START_ELEMENT:
                    StringBuilder att = new StringBuilder();
                    int attributeCount = xmlStreamReader.getAttributeCount();
                    for (int i = 0; i < attributeCount; i++) {
                        String name = xmlStreamReader.getAttributeLocalName(i);
                        String value = xmlStreamReader.getAttributeValue(i);
                        att.append(" ").append(name).append("=\"").append(value).append("\"");
                    }
                    System.out.println(tab + "<" + xmlStreamReader.getLocalName() + att + ">");
                    tab = "\t" + tab;
                    break;
                    case XMLStreamConstants.CHARACTERS:
                        String part = xmlStreamReader.getText();
                        content.append(part.trim());
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        if (content.length() > 0){
                            System.out.println(tab + content);
                            content.setLength(0);
                        }

                        tab = tab.substring(1);
                        System.out.println(tab + "</" + xmlStreamReader.getLocalName() + ">");
                        break;
                    case XMLStreamConstants.END_DOCUMENT:
                        System.out.println("end");
                        break;
                }
            }
        } catch (IOException | XMLStreamException e) {
            e.printStackTrace();
        }

    }
}
