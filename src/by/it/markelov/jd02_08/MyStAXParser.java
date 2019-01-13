package by.it.markelov.jd02_08;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MyStAXParser {
    public static void main(String[] args) {
        String tab = "";
        StringBuilder content = new StringBuilder();

        File fileToParse = new File(Path.pathOfThisDirectory(MySAXParser.class) + File.separator + "clients.xml");
        try {
            FileInputStream file = new FileInputStream(fileToParse);
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLStreamReader reader = factory.createXMLStreamReader(file);

            while (reader.hasNext()) {
                int typeOfElement = reader.next();
                switch (typeOfElement) {
                    case XMLStreamConstants.START_DOCUMENT:
                        System.out.println("Start parse XML-document...");
                        break;
                    case XMLStreamConstants.ATTRIBUTE:
                        System.out.println("============================================================");
                        break;
                    case XMLStreamConstants.START_ELEMENT:
                        StringBuilder attributesOfElement = new StringBuilder();
                        for (int i = 0; i < reader.getAttributeCount(); i++) {
                            String nameOfAttribute = reader.getAttributeLocalName(i);
                            String valueOfAttribute = reader.getAttributeValue(i);
                            attributesOfElement.append(nameOfAttribute).append("=").append("\"").append(valueOfAttribute).append("\"");
                        }
                        System.out.println(tab + "<" + reader.getLocalName() + attributesOfElement + ">");
                        tab = "\t" + tab;
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        String partOfContent = reader.getText();
                        content.append(partOfContent.trim());
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
                        System.out.println("End parse XML-document");
                        break;
                }
            }
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
    }
}
