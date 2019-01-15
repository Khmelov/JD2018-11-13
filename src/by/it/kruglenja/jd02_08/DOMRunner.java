package by.it.kruglenja.jd02_08;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DOMRunner {
    public static void main(String[] args) {
        String file = System.getProperty("user.dir") + "/src/by/it/kruglenja/jd02_07/spareparts/spareparts.xml";
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(file);
            Element element = document.getDocumentElement();
            printDom("", element);
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    private static void printDom(String pref, Node node) {
        String text = node.getNodeValue();
        if (text != null) {
            System.out.println(pref + text.trim());
        }
        NodeList nodeList = node.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            printDom(pref + node.getNodeName() + ">", nodeList.item(i));
        }
    }
}
