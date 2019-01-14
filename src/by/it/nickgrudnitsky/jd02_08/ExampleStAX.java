package by.it.nickgrudnitsky.jd02_08;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExampleStAX {
    private static String tab = "";
    public static void main(String[] args) {
        try {
            String fileName = "src/by/it/nickgrudnitsky/jd02_07/twitch+xsd.xml";
            FileInputStream inputStream = new FileInputStream(fileName);
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            XMLStreamReader streamReader = inputFactory.createXMLStreamReader(inputStream);
            StringBuilder value = new StringBuilder();
            while (streamReader.hasNext()){
                int type = streamReader.next();
                switch (type){
                    case XMLStreamConstants.START_ELEMENT:
                    {
                        System.out.print(tab + "<" + streamReader.getLocalName());
                        tab = "\t" + tab;
                        int countAttribute = streamReader.getAttributeCount();
                        for (int i = 0; i < countAttribute; i++) {
                            System.out.print(" " + streamReader.getAttributeLocalName(i) + "=");
                            System.out.print("\"" + streamReader.getAttributeValue(i) + "\"");
                        }
                        System.out.println(">");
                        break;
                    }
                    case XMLStreamConstants.CHARACTERS:
                    {
                        value = value.append(streamReader.getText().trim());
                        break;
                    }
                    case XMLStreamConstants.END_ELEMENT:
                    {
                        if (value.length() != 0){
                            System.out.println(tab + value);
                        }
                        tab=tab.substring(1);
                        value.setLength(0);
                        System.out.println(tab + "</" + streamReader.getLocalName() + ">");
                        break;
                    }
                }
            }
        } catch (FileNotFoundException | XMLStreamException e) {
            System.out.print("ERROR: " + e.toString());
        }
    }
}
