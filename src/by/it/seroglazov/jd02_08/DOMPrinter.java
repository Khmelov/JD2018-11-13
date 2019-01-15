package by.it.seroglazov.jd02_08;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DOMPrinter {
    public static void main(String[] args) {
        String parentDir = System.getProperty("user.dir") + "/src/by/it/seroglazov/jd02_07/";
        String myIngredientsFile = parentDir + "ingredients/ingredients+xsd.xml";
        String myRecipesFile = parentDir + "recipes/recipes+xsd.xml";
        String myUsersFile = parentDir + "users/users+xsd.xml";
        printFile(myIngredientsFile);
        printFile(myRecipesFile);
        printFile(myUsersFile);
    }

    private static void printFile(String fileName) {
        System.out.println("Reading file " + new File(fileName).getAbsolutePath());
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document doc = documentBuilder.parse(fileName);
            Element elem = doc.getDocumentElement();
            processElement("", elem);
        } catch (ParserConfigurationException e) {
            System.err.println("Parser configuration exception: " + e.getMessage());
        } catch (SAXException e) {
            System.err.println("SAXException: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
        }
        System.out.println("=========================================================================");
        System.out.println();
    }


    private static void processElement(String tab, Node node) {
        int type = node.getNodeType();
        if (type == Node.ELEMENT_NODE) {
            System.out.printf("%s<%s", tab, node.getNodeName());
            if (node.hasAttributes()) {
                NamedNodeMap attributes = node.getAttributes();
                for (int i = 0; i < attributes.getLength(); i++) {
                    Node attr = attributes.item(i);
                    System.out.printf(" %s=\"%s\"", attr.getNodeName(), attr.getNodeValue());
                }
            }
            System.out.println(">");
        }
        String text = node.getNodeValue();
        String newTab = tab.concat("\t");
        if (text != null) {
            text = text.trim();
            if (text.length() > 0) {
                System.out.println(tab + text);
            }
        }
        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            processElement(newTab, childNodes.item(i));
        }
        if (type == Node.ELEMENT_NODE)
            System.out.printf("%s</%s>%n", tab, node.getNodeName());

    }
}
