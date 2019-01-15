package by.it.nickgrudnitsky.jd02_08;

import org.w3c.dom.*;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class ExampleDOM {

    public static void main(String[] args) {
        try {
            String fileName = "src/by/it/nickgrudnitsky/jd02_07/twitch+xsd.xml";
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(fileName);
            Element element = document.getDocumentElement();
            printDom("", element);
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    private static void printDom(String tab, Node node) {
        String prefix = tab;
        short nodeType = node.getNodeType();
        switch (nodeType) {
            case Node.ELEMENT_NODE: {
                System.out.print(prefix + "<" + node.getNodeName());
                prefix = "\t" + prefix;
                if (node.hasAttributes()) {
                    NamedNodeMap attributes = node.getAttributes();
                    for (int i = 0; i < attributes.getLength(); i++) {
                        System.out.print(" " + attributes.item(i));
                    }
                }
                System.out.println(">");
                NodeList childNodes = node.getChildNodes();
                for (int i = 0; i < childNodes.getLength(); i++) {
                    printDom(prefix, childNodes.item(i));

                }

                prefix = prefix.substring(1);

                System.out.println(prefix + "</" + node.getNodeName() + ">");
            }
            case Node.TEXT_NODE: {
                if (node.getNodeValue() != null) {
                    if (node.getNodeValue().trim().length() > 0) {
                        System.out.println(prefix + node.getNodeValue().trim());
                    }
                }
            }
        }
    }
}
